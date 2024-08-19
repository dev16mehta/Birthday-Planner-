import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BirthdayPlanner {
    private ActivityStore mainActivities;
    private CafeStore cafes;
    private RestaurantStore restaurants;

    public BirthdayPlanner() {
        try {
            mainActivities = new ActivityStore("activities.txt");
            cafes = new CafeStore("cafes.txt");
            restaurants = new RestaurantStore("restaurants.txt");
        } catch (IOException e) {
            System.err.println("Error in loading the activity files: " + e.getMessage());
        }
    }

    public List<String> generate(String input) {
        List<String> plan = new ArrayList<>();
        Random random = new Random();

        boolean isCafeOrMain = false;
        boolean isMain = false;

        for (char c : input.toCharArray()) {
            ActivityStore store;
            if (Character.isUpperCase(c)) {
                store = mainActivities;
                isMain = true;
            } else {
                if (random.nextBoolean() && !isCafeOrMain) {
                    store = cafes;
                } else {
                    store = mainActivities;
                }
                isCafeOrMain = true;
                isMain = false;
            }
            String activity = store.getRandomItem(String.valueOf(c));
            if (activity != null) {
                if (isMain && plan.size() >= 2 && plan.get(plan.size() - 2).equals(activity)) {
                    continue;
                }
                if (!isMain && plan.size() >= 1 && plan.get(plan.size() - 1).endsWith("(restaurant)")) {
                    continue;
                }
                plan.add(activity);
            }
        }
        return plan;
    }

    public static void main(String[] args) {
        BirthdayPlanner planner = new BirthdayPlanner();
        List<String> plan = planner.generate(args[0]);

        for (String activity : plan) {
            System.out.println(activity);
        }
    }
}

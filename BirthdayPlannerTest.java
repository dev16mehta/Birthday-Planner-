public class BirthdayPlannerTest {
    public static void main(String[] args) {
        testAdd();
        testGetRandomItem();
    }

    public static void testAdd() {
        ActivityStore store = new ActivityStore();
        store.add("a", "archery");
        store.add("a", "apple bobbing");
        assert store.getRandomItem("a").equals("Archery") || store.getRandomItem("a").equals("Apple bobbing");

        store.add("b", "baking");
        assert store.getRandomItem("b").equals("Baking");

        store.add("c", "cake decorating");
        store.add("c", "car racing");
        assert store.getRandomItem("c").equals("Cake decorating") || store.getRandomItem("c").equals("Car racing");
    }

    public static void testGetRandomItem() {
        ActivityStore store = new ActivityStore();
        assert store.getRandomItem("x") == null;

        store.add("d", "dancing");
        assert store.getRandomItem("d").equals("Dancing");

        store.add("e", "eating");
        store.add("e", "egg hunt");
        assert store.getRandomItem("e").equals("Eating") || store.getRandomItem("e").equals("Egg hunt");
    }

    public static void testLoadFileConstructor() {
    try {
        ActivityStore store = new ActivityStore("activities.txt");
        assert store.getRandomItem("a") != null;
        assert store.getRandomItem("b") != null;
        assert store.getRandomItem("c") != null;
    } catch (IOException e) {
        System.out.println("Error loading activities from file: " + e.getMessage());
    }
    }
}


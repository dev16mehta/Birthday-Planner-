import java.io.*;
import java.util.*;

public class ActivityStore {
    private Map<String, List<String>> store;

    public ActivityStore() {
        store = new HashMap<>();
    }

    public ActivityStore(String filename) throws IOException {
        this();
        loadActivitiesFromFile(filename);
    }

    private void loadActivitiesFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String key = line.substring(0, 1).toLowerCase();
                    String item = line.substring(1);
                    add(key, item);
                }
            }
        }
    }

    public void add(String key, String item) {
        key = key.toLowerCase();
        List<String> items = store.getOrDefault(key, new ArrayList<>());
        items.add(item);
        store.put(key, items);
    }

    public String getRandomItem(String key) {
        key = key.toLowerCase();
        List<String> items = store.get(key);
        if (items == null || items.isEmpty()) {
            return null;
        }
        Random random = new Random();
        String randomItem = items.get(random.nextInt(items.size()));
        return capitalizeKey(key) + randomItem.substring(1).toLowerCase();
    }

    private String capitalizeKey(String key) {
        return key.substring(0, 1).toUpperCase() + key.substring(1);
    }
}

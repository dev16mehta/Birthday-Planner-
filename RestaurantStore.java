import java.io.*;
import java.util.*;

public class RestaurantStore extends ActivityStore {
    public RestaurantStore() {
        super();
    }

    public RestaurantStore(String filename) throws IOException {
        super(filename);
    }

    @Override
    public String getRandomItem(String key) {
        return super.getRandomItem(key) + " (restaurant)";
    }
}

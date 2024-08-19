import java.io.*;
import java.util.*;

public class CafeStore extends ActivityStore {
    public CafeStore() {
        super();
    }

    public CafeStore(String filename) throws IOException {
        super(filename);
    }

    @Override
    public String getRandomItem(String key) {
        return super.getRandomItem(key) + " (cafe)";
    }
}


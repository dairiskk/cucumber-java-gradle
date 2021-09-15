package helpers;

import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private static Map<Object, Object> userData = new HashMap<>();

    public static void setData(String key, String data) {
        userData.put(key, data);
    }

    public static Object getData(String key) {
        return userData.getOrDefault(key, key);
    }
}

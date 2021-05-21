package Threads.ConcurrentPackage.CollectionUseExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {

    /**
     * Here we use synchronized methods
     * threads to access the methods in rotation
     */

    private Map<String, Object> foodData = new HashMap<>();

    public synchronized void put(String key, Object value) {
        foodData.put(key, value);
    }

    public synchronized Object get(String key) {
        return foodData.get(key);
    }

    /**
     * But instead we can use thread safe collections
     * without the 'synchronized' word in the method signature
     */

    private Map<String, Object> conCurrentFoodData = new ConcurrentHashMap<>();

    public void conCurrentPut(String key, Object value) {
        conCurrentFoodData.put(key, value);
    }

    public Object conCurrentGet(String key) {
        return conCurrentFoodData.get(key);
    }
}

package JavaCollections.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCollections {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>(); // not in order
        hashMap.put("name1", 1);
        hashMap.get("name1");
        hashMap.remove("name1");
        hashMap.containsKey("name1");
        hashMap.containsValue(1);
        hashMap.size();
        hashMap.isEmpty();

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(); // in order
        linkedHashMap.put("name1", 1);
        linkedHashMap.put("name2", 2);
        linkedHashMap.put("name3", 3);
        linkedHashMap.keySet(); // list of keys
        linkedHashMap.values(); // list of values

        /*  how to print  */
        for (Map.Entry<String, Integer> item: linkedHashMap.entrySet()) {
            System.out.println("Key: %s; Value: %s".formatted(item.getKey(), item.getValue()));
        }

        Map<String, Integer> treemap = new TreeMap<>(); // in alphabetical order (a, b, ...; 1, 2, ...)
        treemap.put("name1", 1);
    }
}

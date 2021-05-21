package Threads.ConcurrentPackage.MemoryProblem;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    /**
     * 'ConcurrentModificationException' appears when two threads
     * try to change the same collection. But such an exception
     * can arise in single-threaded mode.
     *
     * In this application the problem is that the 'ketSet()' iterator
     * does not update after each iteration(when we delete the elements)
     * @param args
     */

    public static void main(String[] args) {
        Map<String, Object> foodData = new HashMap<>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);

        for (String key: foodData.keySet()) { // ConcurrentModificationException
            foodData.remove(key);
        }
    }
}

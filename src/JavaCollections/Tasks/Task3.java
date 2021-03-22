package JavaCollections.Tasks;

import java.util.HashSet;
import java.util.Map;

/**
 * Написать метод isUnique, котоырй принимает
 * Map<String, String> и возвращает true, если
 * каждому ключу соответствует его уникальное значение
 * Пример:
 * здесь true: {Jessica: Miller, Hal: Camp}
 * здесь false: {Jessica: Miller, Hal: Miller}
 */

public class Task3 {

    public static void main(String[] args) {
        Map<String, String> map = Map.of(
                "Jessica", "Miller",
                "Hal", "Miller"
        );
        System.out.println(isUnique(map));
    }

    public static boolean isUnique(Map<String, String> map) {
        return map.size() == new HashSet<>(map.values()).size();
    }
}

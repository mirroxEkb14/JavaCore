package Stream.Tasks.Habr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Метод distinct возвращает stream без дубликатов,
 * при этом для упорядоченного стрима (например, коллекция на основе list)
 * порядок стабилен, для неупорядоченного — порядок не гарантируется.
 * Рассмотрим результаты работы над коллекцией
 * Collection ordered = Arrays.asList(«a1», «a2», «a2», «a3», «a1», «a2», «a2») и
 * Collection nonOrdered = new HashSet<>(ordered).
 */

public class DistinctDemo {

    public static void main(String[] args) {
        List<String> ordered = Arrays.asList(
                "a1", "a2", "a2", "a3", "a1", "a2", "a2"
        );
        Set<String> nonOrdered = new HashSet<>(ordered);

        System.out.println(task1(nonOrdered));
        System.out.println(task2(ordered));
    }

    /**
     * Получение коллекции без дубликатов из неупорядоченного стрима
     */
    public static List<String> task1(Set<String> strings) {
        // порядок не гарантируется
        return strings.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Получение коллекции без дубликатов из упорядоченного стрима
     */
    public static List<String> task2(List<String> strings) {
        // порядок гарантируется
        return strings.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

package Stream.StreamMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCollectionMethod {

    /**
     * Собирает элементы в заданную коллекцию. Если нужно конкретно указать,
     * какой List, Set или другую коллекцию мы хотим использовать, то этот метод поможет.
     * @param args
     */

    public static void main(String[] args) {
        Deque<Integer> deque = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(ArrayDeque::new));

        LinkedHashSet<Integer> set = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}

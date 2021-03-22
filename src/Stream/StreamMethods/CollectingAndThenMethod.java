package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectingAndThenMethod {

    /**
     * Собирает элементы с помощью указанного коллектора,
     * а потом применяет к полученному результату функцию.
     */
    public static void main(String[] args) {
        List<Integer> strings = Arrays.asList(
                1, 2, 3, 4
        );

        List<String> list = strings.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                Function.identity(),
                                s -> s + s
                        ),
                        map -> map.entrySet().stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList())
                ));
        System.out.println(list);
    }
}

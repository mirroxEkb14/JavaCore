package Stream.StreamMethods;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByMethod {

    /**
     * Тут мы буквально «делим пополам» наш стрим по некоему условию
     */

    /**
     * Разбивает последовательность элементов по какому-либо критерию.
     * В одну часть попадают все элементы, которые удовлетворяют переданному условию,
     * во вторую — все, которые не удовлетворяют.
     */
    public static void main(String[] args) {
        Map<Boolean, List<String>> map1 = Stream.of(
                "aa", "bb", "ccc", "ddd"
        )
                .collect(Collectors.partitioningBy(s -> s.length() <= 2));
        map1.entrySet().forEach(System.out::println);
        /*  false=[ccc, ddd]
            true=[aa, bb]  */

        Map<Boolean, String> map2 = Stream.of(
                "aa", "bb", "ccc", "ddd"
        )
                .collect(Collectors.partitioningBy(
                        s -> s.length() <= 2,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining(", ")
                        )
                ));
        map2.entrySet().forEach(System.out::println);
        /*  false=CCC, DDD
            true=AA, BB  */
    }
}

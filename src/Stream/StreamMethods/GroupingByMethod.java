package Stream.StreamMethods;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByMethod {

    /**
     * Группирует элементы по критерию, сохраняя результат в Map.
     * Вместе с представленными выше агрегирующими коллекторами, позволяет гибко собирать данные.
     */
    public static void main(String[] args) {
        Map<Integer, List<String>> map1 = Stream.of(
                "a", "bb", "ccc", "dddd"
        )
                .collect(Collectors.groupingBy(
                        String::length
                ));
        map1.entrySet().forEach(System.out::println);
        /*  1=[a]
            2=[bb]
            3=[ccc]
            4=[dddd] */


        Map<Integer, String> map2 = Stream.of(
                "a", "bb", "ccc", "dddd"
        )
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining()
                        )
                ));
        map2.entrySet().forEach(System.out::println);
        /*  1=A
            2=BB
            3=CCC
            4=DDDD  */


        Map<Integer, List<String>> map3 = Stream.of(
                "a", "bb", "ccc", "dddd"
        )
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.toList()
                        )
                ));
        map3.entrySet().forEach(System.out::println);
        /*  1=[A]
            2=[BB]
            3=[CCC]
            4=[DDDD]  */
    }
}

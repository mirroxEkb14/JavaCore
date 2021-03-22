package Stream.StreamMethods;

import java.util.List;

public class DistinctMethod {

    public static void main(String[] args) {
        /*  Returns a stream with no duplicates */

        List<Integer> integers = List.of(
                1, 1, 2, 2, 2, 3, 4, 4, 3);

        integers.stream()
                .distinct()
                .forEach(System.out::println); // 1, 2, 3, 4
    }
}

package Stream.StreamMethods;

import java.util.List;

public class SkipMethod {

    public static void main(String[] args) {
        /*  Skips N elements  */

        List<Integer> integers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .skip(8); // 9, 10
    }
}

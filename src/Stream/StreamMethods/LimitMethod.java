package Stream.StreamMethods;

import java.util.List;

public class LimitMethod {

    public static void main(String[] args) {
        /*  Limit the selection to
                a certain number */

        List<Integer> integers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .limit(2); // 1, 2
    }
}

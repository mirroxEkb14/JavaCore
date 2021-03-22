package Stream.StreamMethods;

import java.util.List;

public class MapToMethod {

    public static void main(String[] args) {
        List<Integer> integers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .mapToDouble(Double::valueOf)
                .mapToInt(integer -> Integer.parseInt(String.valueOf(integer)))
                .mapToLong(integer -> Long.getLong(String.valueOf(integer)));
    }
}

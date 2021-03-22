package Stream.StreamMethods;

import java.util.List;

public class MapMethod {

    public static void main(String[] args) {
        /* Transforms each stream element;
           Function interface -> takes 1 argument and returns
                a different type of the argument */

        List<Integer> integers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .map(String::valueOf) // to str
                .map(Integer::parseInt) // to int
                .map(integer -> integer + integer);
    }
}

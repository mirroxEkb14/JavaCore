package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;

public class MatchMethods {

    /**
     * boolean allMatch(Predicate<? super T> predicate)
     *
     * Where, T is the type of the input to the predicate
     * and the function returns true if either all elements
     * of the stream match the provided predicate or
     * the stream is empty, otherwise false.
     *
     *
     * boolean anyMatch(Predicate<? super T> predicate)
     *
     * Where, T is the type of the input to the predicate
     * and the function returns true if any elements of
     * the stream match the provided predicate,
     * otherwise false.
     *
     *
     * boolean noneMatch(Predicate<? super T> predicate)
     *
     * Where, T is the type of the input to the predicate
     * and the function returns true if either no elements
     * of the stream match the provided predicate or the
     * stream is empty, otherwise false.
     */

    /*
        Predicate<T> ->	1 parameter - T
                        returns - boolean
                        abstract method - test
                        принимает 1 параметр и возвращает true-false («проверяльщик»)
     */

    public static void main(String[] args) {

        // Creating a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Check if all elements of stream
        // are divisible by 3 or not using
        // Stream allMatch(Predicate predicate)
        boolean answer = list.stream().allMatch(n -> n % 3 == 0);
        System.out.println(answer); // false



    }
}

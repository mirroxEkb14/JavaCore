package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceMethod {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("iphone", "is", "useless");

        Optional<String> optionalList = list.stream()
                                                .reduce((m, n) -> m + " " + n);

        optionalList.ifPresent(System.out::println);


        // connect letters into a word
        Stream<String> wolfList = Stream.of("w", "o", "l", "f");

        StringBuilder wolfBuilder = wolfList.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(wolfBuilder.toString());
    }
}

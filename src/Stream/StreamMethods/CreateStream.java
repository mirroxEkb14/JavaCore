package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
        Stream<String> emptyStream = Stream.empty();

        Stream<Integer> singleElement = Stream.of(1); // java.util.stream.ReferencePipeline$Head@119d7047

        Stream<Integer> fromArray = Arrays.stream(new Integer[]{1, 2, 3});

        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> listStream = list.stream();

        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 1);
    }
}

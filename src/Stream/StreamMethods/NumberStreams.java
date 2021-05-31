package Stream.StreamMethods;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class NumberStreams {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 5); // 1, 2, 3, 4

        intStream.sum(); // 10

        IntStream intStreamClosed = IntStream.rangeClosed(1 ,5); // 1, 2, 3, 4, 5

        DoubleStream doubleStream = DoubleStream.of(2d, 4d, 6d);
        doubleStream.average().orElse(Double.NaN); // 4
    }
}

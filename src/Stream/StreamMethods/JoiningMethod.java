package Stream.StreamMethods;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningMethod {

    public static void main(String[] args) {
        Stream<String> ohMy = Stream.of("lion", "tiger", "wolf");
        String result1 = ohMy.collect(Collectors.joining(",")); //  // lion, tiger, wolf
    }
}

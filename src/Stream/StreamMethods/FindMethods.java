package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;

public class FindMethods {

    /**
     * The methods are used after 'filter' method
     * returns Optional<T>
     *
     * @param args
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("V", "O", "U", "4", "I", "K");

        System.out.println(list.stream()
                                    .filter(n -> n.startsWith("Y"))
                                    .findAny() // Optional.empty
                                    .orElse(null)); // null
    }
}

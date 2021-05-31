package Stream.StreamMethods;

import java.util.Arrays;
import java.util.List;

public class CountMethod {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "I", "M", "A");

        System.out.println(list.stream()
                                    .count()); // 4
    }
}

package Stream.StreamMethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinMaxMethods {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 2, 5);

        System.out.println(list.stream()
                                .max(Comparator.reverseOrder())); // Optional[-1]


        List<String> strList = Arrays.asList("geeks", "for", "programming");

        // Comparator.comparingInt(str -> str.charAt(str.length() - 1))
        Optional<String> result = strList.stream()
                                        .min((str1, str2) -> Character.compare(
                                                str1.charAt(str1.length() - 1), str2.charAt(str2.length() - 1)));

        if (result.isPresent())
            System.out.println(result.get()); // programming
        else
            System.out.println("-1");
    }
}

package Methods;

import java.util.Collection;
import java.util.List;

public class NumberCollectionToString {

    public static void main(String[] args) {
        // the list of numbers is printed as a string with ","
        System.out.println(joinNumbers(List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        ), ", "));
    }

    public static String joinNumbers(Collection<? extends Integer> numbers, String delimiter) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Integer number : numbers) {
            if (first)
                first = false;
            else
                result.append(delimiter);
            result.append(number);
        }
        return String.valueOf(result);
    }
}

package Stream.Tasks.SkillFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Необходимо список строк перевести в список
 * чисел и произвести их умножение
 */

public class StrToInt {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "1", "2", "3", "4", "2", "2"
        );

        withoutStream(strings);
        withStream(strings);
    }

    public static void withStream(List<String> strings) {
        int result = strings.stream()
                .map(Integer::parseInt)
                .reduce(1, (int1, int2) -> int1 * int2);
        System.out.println(result);
    }

    public static void withoutStream(List<String> strings) {
        int result = 0;
        boolean first = true;
        for (String string: strings) {
            if (first) {
                result = Integer.parseInt(string);
                first = false;
            } else {
                result *= Integer.parseInt(string);
            }
        }
        System.out.println(result);
    }
}

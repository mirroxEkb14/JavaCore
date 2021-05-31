package Stream.Tasks.JavaRush;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalcSameWords {

    /**
     * введем с клавиатуры в список 20 слов и подсчитаем,
     * сколько одинаковых слов в этом списке. Результат представим в виде
     * словаря Map<String, Integer>, где первый параметр – уникальная строка,
     * а второй – число (сколько раз данная строка встречалась в списке).
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 20 words: ");

        String[] words = scanner.nextLine().split(", ");

        System.out.println(countWords(words));
    }

    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(words)
                .forEach(el -> map.merge(el, 1, Integer::sum)); // (oldValue, newValue) -> oldValue + newValue

        return map;
    }
}

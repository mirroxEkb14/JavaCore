package JavaTasks.JavaRush;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1016 {

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

        for (String word: words) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word), map.get(word) + 1);

            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}

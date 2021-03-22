package Stream.Tasks.JavaRush;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2208 {

    /**
     * Сформируй часть запроса WHERE используя StringBuilder.
     * Если значение null, то параметр не должен попадать в запрос.
     * Пример: {"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
     * Результат: "name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
     */

    public static void main(String[] args) {
        String[] array = {"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null};

        System.out.println(format(array));
    }

    public static String format(String[] array) {
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < array.length; i = i + 2) {
            map.put(array[i], array[i + 1]);
        }

        return map.entrySet().stream() // entrySet() -> [name=Ivanov, country=Ukraine, city=Kiev, age=null]
                .filter(p -> p.getValue() != null)
                .map(p -> String.format("%s = '%s'", p.getKey(), p.getValue()))
                .collect(Collectors.joining(" and "));
    }
}

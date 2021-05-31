package Stream.Tasks.JavaRush.CountCharsInFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    /**
     * Программа запускается с одним параметром - именем файла,
     * который содержит английский текст. Посчитать частоту встречания каждого символа.
     * Отсортировать результат по возрастанию кода ASCII (почитать в инете).
     * Пример: ','=44, 's'=115, 't'=116. Вывести на консоль отсортированный результат: [символ1] ча
     */

    public static void main(String[] args) throws IOException {
        String filename = "engfile.txt";

        System.out.println(countChars(filename));
    }

    public static Map<String, Integer> countChars(String filename) throws IOException {
        // path to file
        Path path = Path.of(
                "src", "Stream", "Tasks", "JavaRush", "CountCharsInFile", filename
        );
        Map<String, Integer> map = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            reader.lines()
                    .flatMap(p -> Arrays.stream(p.split("")))
                    .forEach(p -> map.merge(p, 1, Integer::sum));

            return map;
        }

//        Files.lines(path)
//                .collect(Collectors.joining(System.lineSeparator()))
//                .chars()
//                .mapToObj(p -> (char) p)
//                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.comparingByKey()) // Comparator.comparing(Map.Entry::getKey)
//                .forEach(p -> System.out.println("'" + p.getKey() + "'" + "=" + p.getValue()));
//
//        return new LinkedHashMap<>();
    }
}

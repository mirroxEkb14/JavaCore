package Stream.Tasks.JavaRush.CountCertainWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Demo {

    /**
     * Считать с консоли имя файла. Файл содержит слова, разделенные знаками препинания.
     * Вывести в консоль количество слов "world", которые встречаются в файле. Закрыть потоки.
     */

    public static void main(String[] args) throws IOException {
        String filename = "world.txt";

        System.out.println(worldCounter(filename));
    }

    public static long worldCounter(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(
                "src", "Stream", "Tasks", "JavaRush", "CountCertainWord", filename).toFile()))) {

            return reader.lines()
                    .map(p -> p.replaceAll("[^a-zA-Z0-9\\s+]", " ")) // [\\p{P}\\s]
                    .flatMap(p -> Arrays.stream(p.split("\\s+")))
                    .filter("world"::equalsIgnoreCase)
                    .count();
        }
    }
}

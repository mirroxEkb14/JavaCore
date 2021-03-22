package Stream.Tasks.JavaRush.Task1925;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1925 {

    /**
     * В метод main первым параметром приходит имя файла1,
     * вторым — файла2. Файл1 содержит слова, разделенные пробелом.
     * Записать через запятую в Файл2 слова, длина которых строго больше 6.
     * В конце файла2 запятой не должно быть. Закрыть потоки.
     */

    public static void main(String[] args) throws IOException {
        String first = "first.txt";
        String second = "second.txt";

//        writeFile(first, second);
        writeFile(first, second);
    }

    public static void writeFile(String first, String second) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(
                "workspace", "java", "module", "src", "Stream", "Tasks", "JavaRush", "Task1925", first).toFile()))) {

            BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(
                    "workspace", "java", "module", "src", "Stream", "Tasks", "JavaRush", "Task1925", second).toFile()));

            writer.write(reader.lines()
                    .flatMap(p -> Arrays.stream(p.split("\\n")))
                    .flatMap(p -> Arrays.stream(p.split("\\s+")))
                    .filter(p -> p.length() > 6)
                    .map(p -> p.replaceAll("\\s+", ", "))
                    .collect(Collectors.joining(",\n")));

/*

flatmap:                        flatmap:     filter:               map:             collect:
java rush do tasks every        java         word.length() > 6     E431ZZde         E431ZZde,
day easy E431ZZde re r3 fe      rush                               grt3et3etf3      grt3et3etf3
fge                             do
ge grt3et3etf3                  ...

*/
            writer.close();
        }
    }

//    public static String readFileStream(String first) throws IOException {
//        Path firstPath = Path.of(
//                "workspace", "java", "module", "src", "Stream", "Tasks", "JavaRush", "Task1925", first
//        );
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(firstPath.toFile()))) {
//
//            return reader.lines()
//                    .flatMap(p -> Arrays.stream(p.split("\\n")))
//                    .map(p -> p.replaceAll("\\s+", ", "))
//                    .collect(Collectors.joining(",\n"));
//        }
//    }
//
//    public static void writeFileStream(String first, String second) throws IOException {
//        Path secondPath = Path.of(
//                "workspace", "java", "module", "src", "Stream", "Tasks",  "JavaRush", "Task1925", second
//        );
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(secondPath.toFile()))) {
//            writer.write(readFileStream(first));
//        }
//    }
}

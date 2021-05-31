package Stream.Tasks.JavaRush.WriteFromFileToFile;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    /**
     * Считать с консоли 2 имени файла. Вывести во второй файл все числа,
     * которые есть в первом файле. Числа выводить через пробел.
     * Закрыть потоки. Пример тела файла: 12 text var2 14 8v 1 Результат: 12 14 1
     */

    public static void main(String[] args) throws IOException {
        String[] names = {"first.txt", "second.txt"};

        System.out.println(toSecond(names[1], fromFirst(names[0]))?
                "The data have been written": "There are no integers in the 'first' file");
    }

    public static boolean toSecond(String filename, Integer[] integers) throws IOException {
        if (integers.length > 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(
                    "src", "Stream", "Tasks", "JavaRush", "WriteFromFileToFile", filename).toFile()))) {

                for (Integer integer: integers) {
                    writer.write(integer + " ");
                }
            }
            return true;
        }
        return false;
    }

    public static Integer[] fromFirst(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(
                "workspace", "java", "module", "src", "Stream", "Tasks", "JavaRush", "Task1908", filename).toFile()))) {

            return reader.lines()
//                    .map(p -> p.split("\\s+"))
//                    .map(Arrays::stream)
                    .flatMap(p -> Arrays.stream(p.split("\\s+")))
                    .filter(p -> p.replaceAll("[0-9]", "").length() == 0)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            //            .map(word -> Arrays.stream(word.split(" "))
            //            .filter(e -> e.matches("\\d+"))
            //            .collect(Collectors.joining(" ")))
            //            .collect(Collectors.joining()));
        }
    }
}

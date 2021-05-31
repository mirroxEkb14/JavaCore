package Files.Tasks.NumbersInArow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Вывести наибольшее число цифр,
 * идущих подряд
 */

public class Demo {

    public static void main(String[] args) throws IOException {
        Files.readAllLines(Path.of("src", "Files", "Tasks", "NumbersInArow", "textfile.txt")).stream()
                .map(Demo::findMaxDigitCount)
                .forEach(System.out::println);
    }

    public static int findMaxDigitCount(String line) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                counter++;
            } else {
                if (result < counter) {
                    result = counter;
                }
                counter = 0;
            }
        }
        return Math.max(result, counter);
    }
}

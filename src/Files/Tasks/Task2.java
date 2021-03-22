package Files.Tasks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Вывести в консоль все слова, для которых последняя буква
 * одного слова совпадает с первой буквой следующего слова
 */

public class Task2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of(
                "workspace", "java", "module", "src", "Files", "Tasks", "task2.txt"))) {
            String prevValue = null;
            if (scanner.hasNext()) {
                prevValue = scanner.next();
            }
            while (scanner.hasNext()) {
                String curValue = scanner.next();

                if (isEqualFirstAndLast(prevValue, curValue)) {
                    System.out.println(prevValue + " " + curValue);
                }
                prevValue = curValue;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static boolean isEqualFirstAndLast(String prevValue, String curValue) {
        return prevValue.charAt(prevValue.length() - 1) == curValue.charAt(0);
    }
}

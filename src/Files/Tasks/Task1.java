package Files.Tasks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Вывести в консоль все слова, начинающиеся с гласной в заданном файле
 */

public class Task1 {

    private static final String VOWELS = "eyuioaEYUIOA";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of(
                "workspace", "java", "module", "src", "Files", "Tasks", "task1.txt"))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstSymbol = word.charAt(0);
                if (VOWELS.indexOf(firstSymbol) != -1) {
                    System.out.println(word);
                }

            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

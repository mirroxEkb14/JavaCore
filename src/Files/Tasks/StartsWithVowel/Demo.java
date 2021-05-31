package Files.Tasks.StartsWithVowel;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Вывести в консоль все слова, начинающиеся с гласной в заданном файле
 */

public class Demo {

    private static final String VOWELS = "eyuioaEYUIOA";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of(
                "src", "Files", "Tasks", "StartsWithVowel", "taskfile.txt"))) {
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

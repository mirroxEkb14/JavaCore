package Files.Tasks;

import java.io.*;
import java.nio.file.Path;

/**
 * Напишите программу, которая подсчитывает
 * количество слов в файле
 */

public class Task832 {

    public static void main(String[] args) throws IOException {
        File file = Path.of(
                "workspace", "java", "module", "src", "Files", "Tasks", "task832.txt").toFile();

        try (FileInputStream reader = new FileInputStream(file)) {
            int length;
            byte[] byteArray = new byte[(int) file.length()];
            reader.read(byteArray);
            String fileText = new String(byteArray);
            String[] strArray = fileText.split(" ");
            length = strArray.length;

            System.out.println("Number of words in the file: " + length);
        }
    }
}

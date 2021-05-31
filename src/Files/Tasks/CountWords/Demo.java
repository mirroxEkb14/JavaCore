package Files.Tasks.CountWords;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Напишите программу, которая подсчитывает
 * количество слов в файле
 */

public class Demo {

    public static void main(String[] args) throws IOException {
        File file = Path.of(
                "src", "Files", "Tasks", "CountWords", "textfile.txt").toFile();

        try (FileInputStream reader = new FileInputStream(file)) {
            int length;
            byte[] byteArray = new byte[(int) file.length()];
            reader.read(byteArray);
            String fileText = new String(byteArray); // read write write read читать писать Б А ПАРкапкк \n ауй3№;3 ЛЗЩgrwg #$FEFпцку
            String[] strArray = fileText.split(" "); // [read, write, write, read, читать, писать, Б, А, ПАРкапкк \n ауй3№;3, ЛЗЩgrwg, #$FEFпцку]
            length = strArray.length;

            System.out.println("Number of words in the file: " + length); // 11
        }
    }
}

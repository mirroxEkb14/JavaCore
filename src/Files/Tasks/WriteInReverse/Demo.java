package Files.Tasks.WriteInReverse;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Создайте текстовый файл с таким содержимым:
 * 1
 * 12
 * 123
 * 1234
 * 12345
 * 123456
 * 1234567
 * 12345678
 * 123456789
 *
 * Теперь запишите содержимое этого файла в другой файл со строками, записанными в обратном порядке.
 */

public class Demo {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(
                "src", "Files", "Tasks", "WriteInReverse", "textfile.txt").toFile()))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(
                    "src", "Files", "Tasks", "WriteInReverse", "towritefile.txt").toFile()));

            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine()).append("\n");
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()); // delete the last '\n'

            writer.write(stringBuilder.reverse().toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package Files.Tasks.Task4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Перезаписать в заранее созданный файл java-код из
 * другого файла, заменив все "public" в объявлении атребутов
 * и методов на "private"
 */

public class Task4 {

    public static void main(String[] args) throws IOException {
        writeFile(readFile());

    }

    public static void writeFile(byte[] bufferedInputStreamBytes) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "Tasks", "Task4", "task4.txt").toFile()))) {

//            String strValue = Files.readString(Path.of(
//                    "workspace", "java", "module", "src", "Files", "Tasks", "Task4", "task4.txt"));

            String strValue = new String(bufferedInputStreamBytes);
            bufferedOutputStream.write(strValue.replace("public", "private").getBytes());

        } catch (IOException e) {
            throw new IOException("IOException in the 'writeFile' method: " + e.getMessage());
        }

    }

    public static byte[] readFile() throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "Tasks", "Task4", "Task4Class.java").toFile()))) {
            return bufferedInputStream.readAllBytes();

        } catch (IOException e) {
            throw new IOException("IOException in the 'readValue' method: " + e.getMessage());
        }
    }
}

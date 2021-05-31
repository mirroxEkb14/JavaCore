package Files.Tasks.PublicToPrivate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Перезаписать в заранее созданный файл java-код из
 * другого файла, заменив все "public" в объявлении атребутов
 * и методов на "private"
 */

public class Demo {

    public static void main(String[] args) throws IOException {
        writeFile(readFile());

    }

    public static void writeFile(byte[] bufferedInputStreamBytes) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(Path.of(
                "src", "Files", "Tasks", "PublicToPrivate", "textfile.txt").toFile()))) {

//            String strValue = Files.readString(Path.of(
//                    "workspace", "java", "module", "src", "Files", "Tasks", "Task4", "textfile.txt"));

            String strValue = new String(bufferedInputStreamBytes);
            bufferedOutputStream.write(strValue.replace("public", "private").getBytes());

        } catch (IOException e) {
            throw new IOException("IOException in the 'writeFile' method: " + e.getMessage());
        }

    }

    public static byte[] readFile() throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(Path.of(
                "src", "Files", "Tasks", "PublicToPrivate", "textfile.txt", "ClassToRewrite.java").toFile()))) {
            return bufferedInputStream.readAllBytes();

        } catch (IOException e) {
            throw new IOException("IOException in the 'readValue' method: " + e.getMessage());
        }
    }
}

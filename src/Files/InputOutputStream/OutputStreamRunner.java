package Files.InputOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStreamRunner {

    public static void main(String[] args) {
        /*                 output stream
            application ------------> file */


        /*  how to write (1)
            new FileOutputStream(..., false/true) -> append or rewrite  */

        try (FileOutputStream fileOutputStream = new FileOutputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "output.txt").toFile(), false)) {
            String stringValue = "string";
            fileOutputStream.write(stringValue.getBytes());

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


        // how to write (2)
        try (BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "output.txt").toFile(), false))) {
            String stringValue = "string";
            fileOutputStream.write(stringValue.getBytes());
            fileOutputStream.write(System.lineSeparator().getBytes()); // start writing with "\n"

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

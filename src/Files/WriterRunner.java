package Files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterRunner {

    public static void main(String[] args) throws IOException {

        // how to write (1)
        try (FileWriter fileWriter = new FileWriter(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test.poem").toFile(), true)) {
            fileWriter.write("string1");
            fileWriter.write(System.lineSeparator());
            fileWriter.write("string2");

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


        // how to write (2)
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test.poem").toFile(), true))) {
            fileWriter.write("string1");
            fileWriter.newLine();
            fileWriter.write("string2");

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


        // how to write (3)
        try (BufferedWriter fileWriter = Files.newBufferedWriter(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test.poem"))) {
            fileWriter.write("string1");
            fileWriter.newLine();
            fileWriter.write("string2");

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // how to write (4)
        Files.write(Path.of("workspace", "java", "module", "src", "Files", "FileDirectory", "test.poem"), List.of("string1", "string2"));
    }
}

package Files.ReaderWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderRunner {

    public static void main(String[] args) {
        /*  when we deal with text file  */

        // how to read (1)
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test1.txt").toFile()))) {
            String stringValue = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(stringValue);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // how to read (2)
        try (Stream<String> lines = Files.lines(Path.of("workspace", "java", "module", "src", "Files", "FileDirectory", "test.poem"))) {
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}

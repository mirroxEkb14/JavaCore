package Files.ReaderWriter.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderRunner {

    public static void main(String[] args) throws IOException {
        /*  when we deal with text file  */

        // how to read (0)
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src", "Files", "ReaderWriter", "Reader", "filereader.txt"), StandardCharsets.US_ASCII)) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // how to read (1)
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Path.of(
                "src", "Files", "ReaderWriter", "Reader", "filereader.txt").toFile()))) {
            String stringValue = bufferedReader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(stringValue); // qwerty1234

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // how to read (2)
        try (Stream<String> lines = Files.lines(Path.of("src", "Files", "ReaderWriter", "Reader", "filereader.txt"))) {
            lines.forEach(System.out::println); // qwerty1234

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // how to read (3)
        List<String> list = Files.readAllLines(Path.of("src", "Files", "ReaderWriter", "Reader", "filereader.txt"));
    }
}

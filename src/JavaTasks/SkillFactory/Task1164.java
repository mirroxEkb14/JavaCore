package JavaTasks.SkillFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Task1164 {

    /**
     * Создайте текстовый файл с таким содержимым:
     *
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

    public static void main(String[] args) throws IOException {
        rewriteFileTwo("first.txt");

    }

    public static void rewriteFile(String filename) throws IOException {
        Path pathToWrite = Path.of(
                "workspace", "java", "module", "src", "JavaTasks", "SkillFactoryTasks", "second.txt");

        Path pathToRead = Path.of(
                "workspace", "java", "module", "src", "JavaTasks", "SkillFactoryTasks", filename
        );

        String[] text = readFile(pathToRead);

        if (!Files.exists(pathToWrite)) {
            new File(String.valueOf(pathToWrite)).createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWrite.toFile()))) {
            for (int i = text.length - 1; i >= 0; i--) {
                writer.write(text[i]);
                writer.newLine();
            }
        }
    }

    public static String[] readFile(Path pathToRead) throws IOException {
        if (Files.exists(pathToRead)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathToRead.toFile()))) {
                return reader.lines()
                        .flatMap(p -> Arrays.stream(p.split("\\n")))
                        .toArray(String[]::new);
            }

        } else throw new NoSuchFileException("The file you passed does not exist");
    }

    /*  Method 2  */

    public static void rewriteFileTwo(String filename) throws IOException {
        Path pathToWrite = Path.of(
                "workspace", "java", "module", "src", "JavaTasks", "SkillFactoryTasks", "second.txt");

        Path pathToRead = Path.of(
                "workspace", "java", "module", "src", "JavaTasks", "SkillFactoryTasks", filename
        );

        List<String> text = readFileTwo(pathToRead);

        if (!Files.exists(pathToWrite)) {
            new File(String.valueOf(pathToWrite)).createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWrite.toFile()))) {
            for (int i = text.size() - 1; i >= 0; i--) {
                writer.write(text.get(i));
                writer.newLine();
            }
        }
    }

    public static List<String> readFileTwo(Path pathToRead) throws IOException {
        if (Files.exists(pathToRead)) {
            return Files.readAllLines(pathToRead);

        } else throw new NoSuchFileException("The file you passed does not exist");
    }
}
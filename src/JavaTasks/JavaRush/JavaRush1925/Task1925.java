package JavaTasks.JavaRush.JavaRush1925;

import java.io.*;
import java.nio.file.Path;

public class Task1925 {

    /**
     * В метод main первым параметром приходит имя файла1,
     * вторым — файла2. Файл1 содержит слова, разделенные пробелом.
     * Записать через запятую в Файл2 слова, длина которых строго больше 6.
     * В конце файла2 запятой не должно быть. Закрыть потоки.
     */

    public static void main(String[] args) throws IOException {
        String first = "first.txt";
        String second = "second.txt";

        writeFile(first, second);
    }

    public static void writeFile(String first, String second) throws IOException {
        Path firstPath = Path.of(
                "workspace", "java", "module", "src", "JavaTasks", "JavaRush1925", first
        );
        Path secondPath = Path.of(
                "workspace", "java", "module", "src", "Stream", "Tasks",  "JavaRush", "Task1925", second
        );

        try (BufferedReader reader = new BufferedReader(new FileReader(firstPath.toFile()))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(secondPath.toFile()));

            StringBuilder toWrite = new StringBuilder();
            while (reader.ready()) {
                String[] line = reader.readLine().split("\\s+");

                for (int i = 0; i < line.length; i++) {
                    if (line[i].length() > 6) {
                        toWrite.append(line[i]).append(", ");

                        if (i == line.length - 1)
                            toWrite.append("\n");
                    }
                }
            }
            writer.write(String.valueOf(toWrite).substring(0, toWrite.length() - 3));
            writer.close();
        }
    }
}

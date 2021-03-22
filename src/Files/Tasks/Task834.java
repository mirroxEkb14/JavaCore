package Files.Tasks;

import java.io.*;

/**
 * Написать программу, которая сможет добавлять текст в
 * начало или в конец файла, а также выводить содержимое
 * файла в консоль
 */

public class Task834 {

    private final File file;

    public Task834(File file) {
        this.file = file;
        if (!file.canRead() || !file.canWrite()) {
            throw new IllegalArgumentException("The file cannot be read and written");
        }
    }

    public void addToBeginning(String text) throws IOException {
        File temp = File.createTempFile("temp", ".txt");
        this.copyFile(file, temp);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            BufferedReader reader = new BufferedReader(new FileReader(temp));
            writer.write(text);
            while (reader.ready()) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            writer.flush();
        }
    }

    public void addToEnd(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(text);
            writer.flush();
        }
    }

    public void printFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }
    }

    private void copyFile(File original, File temp) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(temp, false))) {
            BufferedReader reader = new BufferedReader(new FileReader(original));
            while (reader.ready()) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            writer.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        String firstLine = "First line";
        String lastLine = "Last line";

        File example = File.createTempFile("task834", ".txt");
        Task834 appender = new Task834(example);

        appender.addToEnd(lastLine);
        appender.addToBeginning(firstLine);
        appender.addToEnd(lastLine);
        appender.addToBeginning(firstLine);

        appender.printFile();
    }
}

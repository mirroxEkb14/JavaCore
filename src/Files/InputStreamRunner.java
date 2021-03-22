package Files;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class InputStreamRunner {

    public static void main(String[] args) throws FileNotFoundException {
        /*  when we deal with type of bytes (pictures, text files etc.)
                           input stream(read)
            application <------------- file  */


        // path to file (2 ways)
        FileInputStream firstWay = new FileInputStream(String.join(
                File.separator, "workspace", "java", "module", "src", "Files", "FileDirectory", "test1.txt"));

        FileInputStream secondWay = new FileInputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test1.txt").toFile());


        // how to read (1)
        try (FileInputStream fileInputStream1 = new FileInputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test1.txt").toFile())) {
            byte[] bytes = fileInputStream1.readAllBytes();
            String stringValue = new String(bytes);
            System.out.println(stringValue);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


        // how to read (2)
        try (FileInputStream fileInputStream2 = new FileInputStream(Path.of(
                "workspace", "java", "module", "src", "Files", "FileDirectory", "test1.txt").toFile())) {
            byte[] bytes = new byte[fileInputStream2.available()];
            int counter = 0;
            byte curByte;

            while ((curByte = (byte) fileInputStream2.read()) != -1) {
                bytes[counter++] = curByte;
            }
            String strValue = new String(bytes);
            System.out.println(strValue);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            String collect = bufferedReader.lines()
//                    .collect(Collectors.joining("\n"));
//
//            System.out.println(collect);
//
//        } catch (IOException e) {
//            System.out.println("IO Exception: " + e.getMessage());
//        }
//
//
//        // (file, true) - append (not rewrite)
//        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, false))) {
//            String value = "some text";
//            outputStream.write(value.getBytes());
//            outputStream.write(System.lineSeparator().getBytes());
//
//        } catch (IOException e) {
//            System.out.println("IO Exception: " + e.getMessage());
//        }
    }
}

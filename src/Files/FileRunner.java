package Files;

import java.io.File;
import java.io.IOException;

public class FileRunner {

    public static void main(String[] args) throws IOException {

        // '\' - спец. символ, экранировать с помощью '\', то есть '\\'

        /*                  output stream
            application ------------> file
                            input stream
            application <------------- file


            InputStream -> read(); read(byte[] b)
            OutputStream ->  write(int b)  */

        File file = new File("workspace/java/moule/src/Files/test.txt");
        file.createNewFile();
        file.exists();
        file.getAbsolutePath(); // C:\Users\Daniyar\projects\workspace\java\module\src\Files\test.txt
        file.length();
        file.getName(); // test.txt
        file.getParent(); // workspace\java\module\src\Files
        file.getPath(); // workspace\java\module\src\Files\test.txt
        file.isFile();

        File dir = new File("workspace/java/module/src/Files/testDirectory1/testDirectory2");
        dir.mkdirs(); // created "testDirectory1/testDirectory2"

        /*  get file size  */
        long length = 0;
        File[] files = new File("workspace/java/module/FileDirectory").listFiles();
        int count = files.length; // how many files or directories

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
        }
        System.out.println(length);
    }
}

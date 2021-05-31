package Files.ClassFiles.DeleteMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {

        // deletes empty directory
        // 'DirectoryNotEmptyException' if folder is not empty
        // 'NoSuchFileException' if file or directory does not exist
        try {
            Files.delete(Paths.get("src/Files/ClassFiles/DeleteMethod/toDelete/textfile.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.deleteIfExists(Paths.get("src/Files/ClassFiles/DeleteMethod/toDelete/textfile.txt"));

        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}

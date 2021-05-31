package Files.ClassFiles.CopyMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {

        // just a folder is copied(without files inside 'directory1' folder)
        // 'FileAlreadyExistsException' if 'directory2' already exists
        try {
            Files.copy(Paths.get("src/Files/ClassFiles/CopyMethod/directory1"), Paths.get("src/Files/ClassFiles/CopyMethod/directory2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // a file is copied (folder 'directory2' has to be created)
        try {
            Files.copy(Paths.get("src/Files/ClassFiles/CopyMethod/directory1/textfile.txt"), Paths.get("src/Files/ClassFiles/CopyMethod/directory2/testfile2.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

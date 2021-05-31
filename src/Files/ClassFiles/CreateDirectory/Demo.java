package Files.ClassFiles.CreateDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {

        // creates 'field' folder (CreateDirectory.field)
        try {
            Files.createDirectory(Paths.get("src/Files/ClassFiles/CreateDirectory/field"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // creates a folder in a folder (CreateDirectory.bison.grass)
        try {
            Files.createDirectories(Paths.get("src/Files/ClassFiles/CreateDirectory/bison/grass"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Files.ClassFiles.MoveMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {

        try {
            Files.move(Paths.get("src/Files/ClassFiles/MoveMethod/zoo"), Paths.get("src/Files/ClassFiles/MoveMethod/zoo-new"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Files.ClassFiles.ExistMethod;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo {

    public static void main(String[] args) {

        boolean ifExists = Files.exists(Paths.get("C:/Users/user/IdeaProjects/JavaCore/src/Files/ClassFiles/ExistMethod/bison.txt"));

        System.out.println(ifExists); // true
    }
}

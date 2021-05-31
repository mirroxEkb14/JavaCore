package Files.GetDirectorySize;

import java.io.File;

public class MyVersion {

    public static void main(String[] args) {
        File file = new File("C:/Users/user/IdeaProjects/JavaCore");
        System.out.printf("Directory`s size is %dBytes\n", file.length());
        System.out.printf("Directory`s size is %dMB\n", file.length() / 2048);
    }
}

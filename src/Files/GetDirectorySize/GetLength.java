package Files.GetDirectorySize;

import java.io.File;

public class GetLength {

    /**
     * Определите размер каталога с файлами с помощью
     * выше изученных методов. На вход подаётся ссылка на папку.
     * На выходе вы должны получить информацию о размере папки в мегабайтах.
     */

    public static void main(String[] args) {
        File folder = new File("C:/Users/user/IdeaProjects/JavaCore"); //Ваша папка
        long size = getFolderSize(folder);
        System.out.println((size / 1024 / 1024) + " MB");
        System.out.println(size + " Bytes");

//        System.out.println();
//        System.out.println(folder.length() / 2048 + " MB");
//        System.out.println(folder.length() + " Bytes");
    }

    private static long getFolderSize(File folder) {
        File[] files = folder.listFiles();
        long length = 0;
        int count = files.length;
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}

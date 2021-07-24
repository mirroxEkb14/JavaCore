package JavaTasks.Module3Tasks;

public class Task10 {

    /**
     * В классе Main дана строка. Выведите в столбик
     * ее подстроки так, чтобы каждую итерацию
     * пропадали первый и последний ее символы.
     * Выводите до тех пор, пока не останется 1 или 2 символа.
     *
     * Пример для строки "helloworld":
     * helloworld
     * elloworl
     * llowor
     * lowo
     * ow
     */

    private static final String string = "helloworld";

    public static void main(String[] args) {
        int counter = string.length();
        for (int i = 0; i < string.length() / 2; i++) {
            System.out.println(string.substring(i, counter));
            counter--;
        }
    }
}

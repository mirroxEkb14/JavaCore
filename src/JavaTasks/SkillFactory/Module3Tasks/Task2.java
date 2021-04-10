package Module3Tasks;

import java.util.Scanner;

public class Task2 {

    /**
     * Напишите программу, в которой пользователя просят ввести имя и пароль.
     * Пароль должен быть ограничен по размеру от 8 до 15 символов.
     * В случае ввода неверного пароля программа должна запрашивать пароль снова и
     * выводить на экран причину ошибки.
     *
     * В случае, если пароль введен верно, программа должна выводить
     * имя пользователя и его пароль. Удачи, и да прибудет с вами сила!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String password;

        System.out.println("Please, enter your name:");
        name = scanner.nextLine();

        System.out.println("Now enter your password(8-15 symbols):");
        password = scanner.nextLine();

        while (true) {
            if (checkPassword(password)) {
                System.out.printf("\nYour name: %s\nand password: %s\n", name, password);
                break;
            }

            System.out.println("\nSorry, you entered the wrong password, try again:");
            password = scanner.nextLine();
        }
    }

    public static boolean checkPassword(String password) {
        return password.length() >= 8 && password.length() <= 15;
    }
}

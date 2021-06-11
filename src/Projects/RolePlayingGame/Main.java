package Projects.RolePlayingGame;

import Projects.RolePlayingGame.model.*;
import Projects.RolePlayingGame.util.PlayerKind;

import java.util.Scanner;

public class Main {

    /**
     *
     */

    public static void main(String[] args) {

        createUserHero();
    }



    // method asks user for nick and main stat, creates a hero
    public static void createUserHero() {
        Scanner scanner = new Scanner(System.in); // read user input
        System.out.println("Role Playing Game.\nAvailable stats: Agility, Force\nExit - 'q'\n\n");

        // take user name
        System.out.println("Nick: ");
        String userName = scanner.nextLine();

        // check if user wants to leave the program
        if (!ifExit(userName)) {

            // take user selected stat
            System.out.println("\nMain stat: ");
            String userStat = scanner.nextLine();

            // check if user wants to leave the program
            if (!ifExit(userStat)) {

                // inner circle to check user entered stat, leave it when the stat is correct
                while (true) {
                    // if the user entered correct stat
                    if (checkInputStat(userStat)) {

                        // create fantasy character
                        // terminal operator -> to check what stat user chose and set it
                        Player hero = new Hero(userName,
                                userStat.equalsIgnoreCase("Agility") ? PlayerKind.AGILITY : PlayerKind.FORCE);

                        break; // leave 'while' loop

                        // if user entered unavailable stats
                    } else {
                        // take user input again
                        System.out.print("\nSuch a stat is unavailable. Try again:\n- ");
                        userStat = scanner.nextLine();

                        // check if user wants to exit the program
                        if (ifExit(userStat)) stopGame();
                    }
                }

            // instead of entering stat user wants to stop the game
            } else {
                stopGame();
            }

        // instead of entering name user wants to stop the game
        } else {
            stopGame();
        }
    }

    // stops the program
    public static void stopGame() {
        System.out.println("\nThe game is over");
        System.exit(0);
    }

    // if user enters 'q' or 'exit' - stop the program
    public static boolean ifExit(String userInput) {
        return userInput.equalsIgnoreCase("q") ||
                userInput.equalsIgnoreCase("exit");
    }

    // returns true if user entered only available stats
    public static boolean checkInputStat(String inputStat) {

        return inputStat.equalsIgnoreCase("Agility") ||
                inputStat.equalsIgnoreCase("Force");
    }
}

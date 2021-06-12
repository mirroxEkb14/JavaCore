package Projects.RolePlayingGame;

import Projects.RolePlayingGame.model.*;
import Projects.RolePlayingGame.service.BattleField;
import Projects.RolePlayingGame.util.PlayerKind;

import java.util.Scanner;

public class Main {

    /**
     *
     */

    static Player hero;
    static Monster monster;

    public static void main(String[] args) {
        System.out.println("Role Playing Game.\nExit - 'q'\n");
        mainMenu();
    }

    // the main menu of the game
    public static void mainMenu() {

        // take user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Main menu\n- Start a fight\n- Create a hero\n\n- ");
        String userInput = scanner.nextLine();

        // check if user wants to stop the game
        if (!ifExit(userInput)) {

            while (true) {
                // check the correctness of user input
                if (createOrStart(userInput)) {

                    // if user selected 'create a hero'
                    if (ifCreate(userInput)) {
                        createUserHero(); // create a hero
                        mainMenu(); // recursion

                        // method ends...

                    // if to start a fight
                    } else {

                        // infinite loop in case the user wants to start the battle before creating a hero,
                        // in this case, after 'else' block(creating a hero) we will go to 'if' block
                        while (true) {

                            // first, we check if a hero is created(user cannot go to fight without a hero)
                            if (hero != null) {

                                System.out.print("\nChoose your enemy: Skeleton, Goblin\n- ");
                                userInput = scanner.nextLine();

                                // infinite loop for user to select his enemy
                                while (true) {

                                    // check the correctness of user input
                                    if (skeletonOrGoblin(userInput)) {

                                        // see who exactly the user wants as an enemy
                                        if (isSkeleton(userInput)) {
                                            monster = new Skeleton(); // create a skeleton

                                            // if a goblin
                                        } else {
                                            monster = new Goblin(); // create a goblin
                                        }

                                        break; // leave 'while' loop

                                        // if incorrect input
                                    } else {
                                        System.out.print("\nOnly either a skeleton or a goblin can be your enemies\n- ");
                                        userInput = scanner.nextLine();

                                        // if the user wants to stop the game
                                        if (ifExit(userInput)) stopGame();
                                    }
                                }

                                // a place where fantasy characters will fight
                                BattleField battleField = new BattleField();
                                battleField.fight(hero, monster);

                                // print user`s hero statistic
                                System.out.printf("\nThe statistic of '%s' fighter:\n", hero.getName());
                                hero.printStatistic();

                                break; // the game is over

                                // if the user wants to start a fight when he does not have a hero
                            } else {
                                System.out.println("\nYou need to create a hero");
                                createUserHero();
                            }
                        }
                    }
                    break; // leave 'while' loop

                    // if user entered something unclear
                } else {
                    System.out.print("\nUnknown command\n- ");
                    userInput = scanner.nextLine();

                    // check if user wants to exit the program
                    if (ifExit(userInput)) stopGame();
                }
            }

            // if wants
        } else {
            stopGame();
        }
    }

    // method asks user for nick and main stat, creates a hero
    public static void createUserHero() {
        Scanner scanner = new Scanner(System.in); // read user input

        // check if a hero already exists
        if (hero != null) {
            System.out.print("\nYou already have a hero: " + hero.getName() + "\nDo you want to recreate him?\n- ");

            // if the answer is 'yes', set existed hero to zero and create a new one
            if (isYes(scanner.nextLine())) {
                hero = null;
                createUserHero(); // recursion
            }
            System.out.println(); // print space

        // if does not exist
        } else {
            System.out.println("\nAvailable stats: Agility, Force\n");

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

                    // infinite loop to check user entered stat, leave it when the stat is correct
                    while (true) {
                        // if the user entered correct stat
                        if (checkInputStat(userStat)) {

                            // create fantasy character
                            // terminal operator -> to check what stat user chose and set it
                            hero = new Hero(userName,
                                    userStat.equalsIgnoreCase("Agility") ? PlayerKind.AGILITY : PlayerKind.FORCE);

                            System.out.println("\nYour hero is created.\n");

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

    // returns false if the user entered something unknown
    public static boolean createOrStart(String userInput) {
        return userInput.equalsIgnoreCase("start a fight") ||
                userInput.equalsIgnoreCase("a fight") ||
                userInput.equalsIgnoreCase("fight") ||
                userInput.equalsIgnoreCase("start") ||
                userInput.equalsIgnoreCase("create a hero") ||
                userInput.equalsIgnoreCase("a hero") ||
                userInput.equalsIgnoreCase("hero") ||
                userInput.equalsIgnoreCase("create");
    }

    // returns true if the user selected to create a hero
    public static boolean ifCreate(String userInput) {
        return userInput.equalsIgnoreCase("create a hero") ||
                userInput.equalsIgnoreCase("a hero") ||
                userInput.equalsIgnoreCase("hero") ||
                userInput.equalsIgnoreCase("create");
    }

    // returns true if the user selected a skeleton or a goblin
    public static boolean skeletonOrGoblin(String userInput) {
        return userInput.equalsIgnoreCase("skeleton") ||
                userInput.equalsIgnoreCase("goblin");
    }

    // true if skeleton
    public static boolean isSkeleton(String userInput) {
        return userInput.equalsIgnoreCase("skeleton");
    }

    public static boolean isYes(String userInput) {
        return userInput.equalsIgnoreCase("yes") ||
                userInput.equalsIgnoreCase("yeah") ||
                userInput.equalsIgnoreCase("of course") ||
                userInput.equalsIgnoreCase("ofcourse") ||
                userInput.equalsIgnoreCase("create") ||
                userInput.equalsIgnoreCase("create a hero");
    }
}

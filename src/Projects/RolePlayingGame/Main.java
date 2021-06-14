package Projects.RolePlayingGame;

import Projects.RolePlayingGame.model.*;
import Projects.RolePlayingGame.service.BattleField;
import Projects.RolePlayingGame.util.PlayerKind;

import java.util.Scanner;

public class Main {

    /**
     *
     */


    /*
        Questions:
            1. Do I need to create static StringBuilder for all methods
     */

    /*
        To add:
            1. potion
            2. hill logic
            3. Merchant
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
        System.out.print("Main menu\n- Go to Twilight Forest\n- Create a hero\n\n- ");
        String userInput = scanner.nextLine();

        // check if user wants to stop the game
        if (!ifExit(userInput)) {

            while (true) {
                // check the correctness of user input
                if (createOrStart(userInput)) {

                    // if user selected 'create a hero'
                    if (ifCreate(userInput)) {
                        createHero(); // create a hero
                        mainMenu(); // recursion

                        // method ends...

                    // if to start a fight
                    } else {

                        // check if the hero exists
                        if (ifHeroExists(hero)) {
                            battleMenu();

                            // method ends...

                        // if the hero does not exist yet
                        } else {
                            System.out.println("\nYou need to create a hero first");
                            createHero();
                            mainMenu(); // recursion

                            // method ends...
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

    // when the battle starts
    public static void battleMenu() {

        // a place where fantasy characters will fight
        final BattleField battleField = new BattleField();

        // create a merchant who sells healing potions
        Merchant merchant = new Merchant();

        // when we get into this for the first time(from main menu), the flag is true, in the first
        // 'while' loop 'if' block is performed firstly, then the other logic, but if the user wins the fight,
        // and then if he selects 'see hero' or 'buy a potion', we set this variable to false, and after that
        // we get into the first 'while' loop, where the 'if' block does not perform
        boolean flag = true;

        // take user input
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // infinite loop in case the user wants to start the battle before creating a hero
        // in this case, after 'else' block(creating a hero) we will go to 'if' block
        while (true) {

            // before the battle we check if all the monsters(3) are defeated
            if (battleField.getDefeatedMonsters() == 3) {
                System.out.println("\nYou defeated all the monsters\nThe game is passed.");
                break; // finish the method

            // if it is the first fight('mainMenu' method calls or the user entered 'continue fighting')
            } else if (flag) {
                // create a monster
                createMonster(battleField.getDefeatedMonsters());

                // FIGHT!
                battleField.fight(hero, monster);
            }

            // if the hero fell
            if (hero.isDead()) {
                System.out.println("\nYou died bravely\nThe game is over.");
                break; // finish the method
            }

            // after the fight ask the user to continue fighting, see his hero statistic or drink potion
            System.out.printf("\nYou won %d %s, %d left\n- Continue fighting\n- See a hero\n- Drink potion\n- Buy a potion\n\n- ",
                    battleField.getDefeatedMonsters(), battleField.getDefeatedMonsters() == 1? "monster": "monsters",
                    3 - battleField.getDefeatedMonsters());

            userInput = scanner.nextLine(); // read input data

            // check if the user wants to leave the game
            if (!ifExit(userInput)) {

                while(true) {
                    // check the correctness of user input
                    if (ContinueOrSeeOrDrinkOrBuy(userInput)) {

                        // if the user wants to keep fighting
                        if (ifContinue(userInput)) {
                            flag = true;
                            break; // leave this 'while' loop and get to the first 'while' loop

                        // if the user wants to see statistic
                        } else if (ifSee(userInput)) {
                            flag = false;
                            printHeroStatistic();
                            break; // get to the first 'while' loop

                        // try to drink a potion
                        } else if (ifDrink(userInput)) {


                        // buy a potion
                        } else {
                            flag = false;

                            // buy a potion, can return 'null'
                           HealingPotion potion = merchant.trade(hero);

                           // check if the hero managed to buy a potion
                            if (potion != null) hero.setPotion(potion); // now the hero has a healing potion

                            // method ends...
                        }

                        break; // leave 'while' loop

                    // if incorrect input
                    } else {
                        System.out.print("\nYou can either continue fighting or see your hero statistic, or buy a potion\n- ");
                        userInput = scanner.nextLine();

                        if (ifExit(userInput)) stopGame();
                    }
                }

            // if the user quits the game
            } else {
                stopGame();
            }
        }
    }

    // method asks user for nick and main stat, creates a hero
    public static void createHero() {
        Scanner scanner = new Scanner(System.in); // read user input

        // check if a hero already exists
        if (hero != null) {
            System.out.print("\nYou already have a hero: " + hero.getName() + "\nDo you want to recreate him?\n- ");

            // if the answer is 'yes', set existed hero to zero and create a new one
            if (isYes(scanner.nextLine())) {
                hero = null;
                createHero(); // recursion
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

    // creates a monster for the user
    public static void createMonster(int defeatedMonsters) {

        // if it is the first battle
        if (defeatedMonsters == 0) {
            monster = new Goblin();

        // if the user defeated goblin
        } else if (defeatedMonsters == 1) {
            monster = new Skeleton();

        // if it is the last round
        } else {
            monster = new Troll();
        }
    }

    // true -> if the hero exists, false otherwise
    public static boolean ifHeroExists(Player hero) {
        return hero != null;
    }

    // print user`s hero statistic
    public static void printHeroStatistic() {
        System.out.printf("\nThe statistic of '%s' fighter:\n", hero.getName());
        hero.printStatistic();
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
                userInput.equalsIgnoreCase("fight!") ||
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

    public static boolean isYes(String userInput) {
        return userInput.equalsIgnoreCase("yes") ||
                userInput.equalsIgnoreCase("yeah") ||
                userInput.equalsIgnoreCase("of course") ||
                userInput.equalsIgnoreCase("ofcourse") ||
                userInput.equalsIgnoreCase("create") ||
                userInput.equalsIgnoreCase("create a hero");
    }

    // after defeating a monster the user can select what to do next
    public static boolean ContinueOrSeeOrDrinkOrBuy(String userInput) {
        return userInput.equalsIgnoreCase("continue") ||
                userInput.equalsIgnoreCase("go on") ||
                userInput.equalsIgnoreCase("go") ||
                userInput.equalsIgnoreCase("let`s go") ||
                userInput.equalsIgnoreCase("lets go") ||
                userInput.equalsIgnoreCase("let`s go on") ||
                userInput.equalsIgnoreCase("lets go on") ||
                userInput.equalsIgnoreCase("fight") ||
                userInput.equalsIgnoreCase("fight!") ||
                userInput.equalsIgnoreCase("see") ||
                userInput.equalsIgnoreCase("see hero") ||
                userInput.equalsIgnoreCase("hero") ||
                userInput.equalsIgnoreCase("heal") ||
                userInput.equalsIgnoreCase("drink") ||
                userInput.equalsIgnoreCase("drink potion") ||
                userInput.equalsIgnoreCase("buy a potion") ||
                userInput.equalsIgnoreCase("buy potion") ||
                userInput.equalsIgnoreCase("buy") ||
                userInput.equalsIgnoreCase("to buy");
    }

    // true -> if the user wants to continue fighting
    public static boolean ifContinue(String userInput) {
        return userInput.equalsIgnoreCase("continue") ||
                userInput.equalsIgnoreCase("go on") ||
                userInput.equalsIgnoreCase("go") ||
                userInput.equalsIgnoreCase("let`s go") ||
                userInput.equalsIgnoreCase("lets go") ||
                userInput.equalsIgnoreCase("let`s go on") ||
                userInput.equalsIgnoreCase("lets go on") ||
                userInput.equalsIgnoreCase("fight") ||
                userInput.equalsIgnoreCase("fight!");
    }

    // true -> if the user wants to see his hero statistic
    public static boolean ifSee(String userInput) {
        return userInput.equalsIgnoreCase("see") ||
                userInput.equalsIgnoreCase("see hero") ||
                userInput.equalsIgnoreCase("hero");
    }

    public static boolean ifDrink(String userInput) {
        return userInput.equalsIgnoreCase("heal") ||
                userInput.equalsIgnoreCase("drink") ||
                userInput.equalsIgnoreCase("drink potion");
    }
}

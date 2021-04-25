package Methods;

import java.util.Random;
import java.util.Scanner;

public class TossACoin {

    /**
     * Напишите программу, которая симулирует подбрасывание одной монеты
     * столько раз, сколько захочет пользователь. Программа должна записывать
     * результаты и подсчитывать сколько раз выпали орел и решка.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean ifExit = false;
        boolean tossedCoin;
        int headCounter = 0;
        int tailCounter = 0;

        System.out.println("Want to toss a coin?(Sure! / Nope)");
        userInput = scanner.nextLine();

        while (!ifExit) {
            if (userInput.equals("Nope") || userInput.equals("nope") ||
                    userInput.equals("No") || userInput.equals("no")) {
                ifExit = true;

            } else {
                tossedCoin = toss();

                if (tossedCoin) { // true -> head
                    System.out.println("\nHead!");
                    headCounter++;
                } else { // false -> tail
                    System.out.println("\nTail!");
                    tailCounter++;
                }

                System.out.println("Want to repeat?");
                userInput = scanner.nextLine();
            }
        }

        System.out.printf("\nYour results:\nHeads: %d\nTails: %d\n", headCounter, tailCounter);
    }

    public static boolean toss() {
        int randomNumber = new Random().nextInt(2);

        return randomNumber == 0;
    }
}

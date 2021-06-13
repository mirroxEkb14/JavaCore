package Projects.RolePlayingGame.model;

import java.util.Random;

    /*
        Merchant sells healing potions for your hero
        One such a potion that merchant sells for 100 gold
     */

public class Merchant {

    private final boolean isAtWork;

    // set 'isAtWork' variable randomly, fifty-fifty
    public Merchant() {
        Random random = new Random();

        isAtWork = random.nextBoolean();
    }

    public HealingPotion trade(int gold) {

        // check if the trader is here(get into this 'if' block if 'isArWork' == false)
        if (!isAtWork) {
            System.out.println("The Merchant is not here");

        // one potion costs 100 gold
        } else if (gold < 100) {
            System.out.println("\nNot enough gold!");

        // if the merchant is here and the hero has enough gold
        } else {
            return new HealingPotion();
        }

        // if the merchant is not here or the hero does not have enough gold
        return null;
    }

}

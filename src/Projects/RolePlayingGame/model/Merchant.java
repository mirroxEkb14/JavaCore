package Projects.RolePlayingGame.model;

import java.util.Random;

    /**
     * Merchant sells healing potions for the hero.
     * One such a potion the merchant sells for 100 gold
     */

public class Merchant {

    // determines either the merchant is available or not
    private boolean isAtWork;

    // his price for one potion
    private final int price = 100;

    // set 'isAtWork' variable
    public Merchant() {
        isAtWork = getRandom();
    }

    // returns a random boolean value, fifty-fifty
    private boolean getRandom() {
        Random random = new Random();
        return random.nextBoolean();
    }

    // the hero passes his gold and buys a potion(if he has enough gold and the merchant is at work)
    public HealingPotion trade(Hero hero) {

        // check if the trader is here(get into this 'if' block if 'isArWork' == false)
        if (!isAtWork) {
            System.out.println("\nThe Merchant is not here");
            isAtWork = getRandom(); // override the variable

        // one potion costs 100 gold
        } else if (hero.getGold() < price) {
            System.out.println("\nNot enough gold!");

        // if the merchant is here and the hero has enough gold
        } else {
            hero.setGold(hero.getGold() - price); // decrease the amount of hero gold by the potion price
            System.out.println("\nThanks for buying, see you");
            return new HealingPotion(); // the result of the trade
        }

        // if the merchant is not here or the hero does not have enough gold
        return null;
    }
}

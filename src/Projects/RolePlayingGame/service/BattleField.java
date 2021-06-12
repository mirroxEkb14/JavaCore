package Projects.RolePlayingGame.service;

import Projects.RolePlayingGame.model.Entity;

import java.util.Random;

    /*
        The fight starts, two characters hit each other in an infinite loop
        (who hits is decided randomly, who has more agility - hits with a greater chance),
        when some character dies, the winner gets xp and gold of the loser, then
        the level of the winner is increased by 1 and the xp is decreased by 100
     */

public class BattleField {

    public void fight(Entity fighter1, Entity fighter2) {
        System.out.println("\n===============================\nFIGHT!\n");

        int hitChance; // number from 0 to 1
        boolean hitResult; // missed or not

        // the fight lasts till one of the fighters dies
        while (fighter1.isAlive() && fighter2.isAlive()) {
             hitChance = getRandom();

            // if '0' -> fighter1 attacks
            if (hitChance == 0) {
                hitResult = fighter1.hit(fighter2);

                // if hit
                if (hitResult) {
                    System.out.printf("%s hits %s\n%dhp - %dhp\n\n", fighter1.getName(),
                            fighter2.getName(), fighter1.getHp(), fighter2.getHp());

                    if (fighter2.isDead()) {
                        System.out.println("\nThe fight ended with the victory of " + fighter1.getName() + "\n===============================");

                        // fighter1 wins, he gets xp and gold of fighter2, also increases his level by 1
                        fighter1.setXp(fighter1.getXp() + fighter2.getXp());
                        fighter1.setGold(fighter1.getGold() + fighter2.getGold());
                        fighter1.levelUp();
                    }

                // if missed
                } else {
                    System.out.println(fighter1.getName() + " missed!");
                }

            // if '1' -> fighter2 attacks
            } else {
                hitResult = fighter2.hit(fighter1);

                // if hit
                if (hitResult) {
                    System.out.printf("%s hits %s\n%dhp - %dhp\n\n", fighter2.getName(),
                            fighter1.getName(), fighter2.getHp(), fighter1.getHp());

                    if (fighter1.isDead()) {
                        System.out.println("\nThe fight ended with the victory of " + fighter2.getName() + "\n===========================");

                        // fighter2 wins, he gets xp and gold of fighter1, also increases his level by 1
                        fighter2.setXp(fighter2.getXp() + fighter1.getXp());
                        fighter2.setGold(fighter2.getGold() + fighter1.getGold());
                        fighter2.levelUp();
                    }

                // if missed
                } else {
                    System.out.println(fighter2.getName() + " missed!");
                }
            }
        }
    }

    // returns a random number - 0 or 1
    public int getRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }
}

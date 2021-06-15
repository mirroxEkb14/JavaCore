package Projects.RolePlayingGame.service;

import Projects.RolePlayingGame.model.Hero;
import Projects.RolePlayingGame.model.Monster;

import java.util.Random;

    /**
     * The fight starts, two characters hit each other in an infinite loop
     * (who hits is decided randomly, who has more agility - hits with a greater chance),
     * when some character dies, the winner gets xp and gold of the loser, then if it is
     * a hero, his level is increased by 1
     */


public class BattleField {

    // the amount of monsters that the hero defeated
    private int defeatedMonsters = 0;

    public void fight(Hero hero, Monster monster) {
        System.out.println("\n===============================\nFIGHT!\n");

        int hitChance; // number from 0 to 1
        boolean hitResult; // missed or not

        // the fight lasts till one of the fighters dies
        while (hero.isAlive() && monster.isAlive()) {
             hitChance = getRandom();

            // if '0' -> hero attacks
            if (hitChance == 0) {
                hitResult = hero.hit(monster);

                // if hit
                if (hitResult) {
                    System.out.printf("%s hits %s\n%dhp - %dhp\n\n", hero.getName(),
                            monster.getName(), hero.getHP(), monster.getHP());

                    // after the strike check if the monster is dead
                    if (monster.isDead()) {
                        System.out.println("\nThe fight ended with the victory of " + hero.getName() + "\n===============================");

                        // the hero wins, he gets xp and gold of the monster, also increases his level by 1
                        hero.setXP(hero.getXP() + monster.getXP());
                        hero.setGold(hero.getGold() + monster.getGold());
                        hero.levelUp();

                        // increment the counter
                        defeatedMonsters++;
                    }

                // if missed
                } else {
                    System.out.println(hero.getName() + " missed!");
                }

            // if '1' -> monster attacks
            } else {
                hitResult = monster.hit(hero);

                // if hit
                if (hitResult) {
                    System.out.printf("%s hits %s\n%dhp - %dhp\n\n", monster.getName(),
                            hero.getName(), monster.getHP(), hero.getHP());

                    // after he strike check if the hero is dead
                    if (hero.isDead()) {
                        System.out.println("\nThe fight ended with the victory of " + monster.getName() + "\n===========================");

                        // the monster wins, he gets xp and gold of the hero
                        monster.setXP(monster.getXP() + hero.getXP());
                        monster.setGold(monster.getGold() + hero.getGold());
                    }

                // if missed
                } else {
                    System.out.println(monster.getName() + " missed!");
                }
            }
        }
    }

    // returns a random number - 0 or 1
    public int getRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    // getter
    public int getDefeatedMonsters() {
        return defeatedMonsters;
    }
}

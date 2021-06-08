package Projects.RolePlayingGame.service;

import Projects.RolePlayingGame.model.Entity;
import Projects.RolePlayingGame.model.Player;

import java.util.Random;

public class Battle {

    /*
       Battle lasts till either a monster or a player is dead('hp' field = 0)

       In an endless circle we generate a random number(0-1),
       if 0, the player attacks the monster,
       if 1, the monster attacks the player
    */
    public void battle(Player player, Entity entity) {
        Random random = new Random();

        while(true) {
            if (random.nextInt(2) == 0) {
                player.attack(entity);
            } else {
                entity.attack(player);
            }

            if (player.getHp() <= 0) {
                
            }
        }
    }

    public void printStatistic(Entity entity) {

    }
}

package Projects.RolePlayingGame.service;

import Projects.RolePlayingGame.model.Entity;

public class BattleField {

    public void fight(Entity attacker, Entity defender) {

        if (attacker.hit(defender)) {
            System.out.println(attacker);
        }
    }

}

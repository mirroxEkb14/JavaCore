package Projects.RolePlayingGame.util;

import Projects.RolePlayingGame.model.Entity;

    /**
     * Monsters and Heroes must attack each other,
     * so we have 'Fighter' interface that says:
     * "Both Monsters and Heroes can fight"
     */

public interface Fighter {

    // method returns the amount of damage of the attacker
    int attack();

    // reduces the passed entity hp by the amount of damage
    // of the attacking entity
    boolean hit(Entity entity);
}

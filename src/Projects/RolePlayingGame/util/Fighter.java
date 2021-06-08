package Projects.RolePlayingGame.util;

    /*
        Monsters and Players must attack each other,
        so we have 'Fighter' interface that says:
        "Both Monsters and Players can fight"
     */

import Projects.RolePlayingGame.model.Entity;

public interface Fighter {

    // method returns the amount of damage of the attacker
    int attack();

    //
    boolean hit(Entity entity);
}

package Projects.RolePlayingGame.util;

    /*
        Monsters and Players must attack each other,
        so we have 'Fighter' interface that says:
        "Both Monsters and Player can fight"

        'printStatistic()' says:
        "Both Monsters and Player can show their statistic"
     */

import Projects.RolePlayingGame.model.Entity;

public interface Fighter {

    // method returns the amount of damage of the attacker
    int attack();

    // reduces the passed entity hp by the amount of gamage
    // of the attacking entity
    boolean hit(Entity entity);

    // prints statistic of the entity to the console
    void printStatistic();
}

package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /**
     * Troll is a monster, so we 'extends Monster'
     */

public class Troll extends Monster {

    public Troll() {
        super(MonsterKind.TROLL); // call 'Monster' constructor
    }
}

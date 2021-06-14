package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /**
     * Goblin is a monster, so we 'extends Monster'
     */

public class Goblin extends Monster {

    public Goblin() {
        super(MonsterKind.GOBLIN); // call 'Monster' constructor
    }
}

package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /*
        Goblin is a monster, so we 'extends Monster'
     */

public class Goblin extends Monster {

    public Goblin() {
        // call 'Monster' constructor
        super(MonsterKind.GOBLIN);
    }
}

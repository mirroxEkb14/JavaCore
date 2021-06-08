package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /*
        Skeleton is a monster, so we 'extends Monster'
     */

public class Skeleton extends Monster {

    public Skeleton() {
        // call 'Monster' constructor
        super(MonsterKind.SKELETON);
    }
}

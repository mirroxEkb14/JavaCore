package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /*
        Monster is an entity, so we 'extends Entity'
     */

public abstract class Monster extends Entity {

    public Monster(MonsterKind kind) {
        // call 'Entity' constructor
        super(kind);
    }
}

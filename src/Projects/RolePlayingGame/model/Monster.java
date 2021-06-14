package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.MonsterKind;

    /**
     * There are three types of monsters in this game, they are all monsters,
     * so this class unites them.
     *
     * Monsters is an entity, so we 'extends Entity'
     */

public abstract class Monster extends Entity {

    public Monster(MonsterKind kind) {
        super(kind); // call 'Entity' constructor
    }
}

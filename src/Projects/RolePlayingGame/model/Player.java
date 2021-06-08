package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.PlayerKind;

    /*
        Player is an entity, so we 'extends Entity'
    */

public abstract class Player extends Entity {

    public Player(String name, PlayerKind kind) {
        // call 'Entity' constructor
        super(name, kind);
    }
}

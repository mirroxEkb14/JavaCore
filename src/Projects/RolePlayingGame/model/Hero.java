package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.PlayerKind;

    /*
        Each hero is a player, so we 'extends Player'
    */

public class Hero extends Player {

    public Hero(String nickName, PlayerKind kind) {
        super(nickName, kind);
    }
}

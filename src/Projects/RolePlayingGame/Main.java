package Projects.RolePlayingGame;

import Projects.RolePlayingGame.model.Hero;
import Projects.RolePlayingGame.model.Monster;
import Projects.RolePlayingGame.model.Player;
import Projects.RolePlayingGame.model.Skeleton;
import Projects.RolePlayingGame.service.BattleField;
import Projects.RolePlayingGame.util.PlayerKind;

public class Main {

    public static void main(String[] args) {
        Player hero = new Hero("destroyer228", PlayerKind.FORCE);
        Monster monster = new Skeleton();

        BattleField battleField = new BattleField();


    }
}

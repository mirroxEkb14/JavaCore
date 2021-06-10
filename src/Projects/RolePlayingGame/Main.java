package Projects.RolePlayingGame;

import Projects.RolePlayingGame.model.*;
import Projects.RolePlayingGame.service.BattleField;
import Projects.RolePlayingGame.util.PlayerKind;

public class Main {

    public static void main(String[] args) {
        // create fantasy characters
        Player hero = new Hero("destroyer228", PlayerKind.FORCE);
        Monster skeleton = new Skeleton();
        Monster goblin = new Goblin();

        // place where they will fight
        BattleField battleField = new BattleField();

        // FIGHT!
        battleField.fight(hero, skeleton);

        // delimiter
        System.out.println("========================");

        // statistics of fantasy characters after the fight
        battleField.statisticOf(hero);
        System.out.println();
        battleField.statisticOf(skeleton);
    }
}

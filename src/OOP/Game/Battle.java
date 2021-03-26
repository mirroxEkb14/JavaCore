package OOP.Game;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    List<Monster> monsters = new ArrayList<>();

    public void add(Monster monster) {
        this.monsters.add(monster);
        System.out.printf("\nThe '%s' is added", monster.getKind());
    }

    public void showParty() {
        StringBuilder fullParty = new StringBuilder("\nParticipants of the battle: ");

        for (Monster m: this.monsters) {
            fullParty.append(m.getKind()).append(", ");
        }

        System.out.println(fullParty.substring(0, fullParty.length() - 2));
    }
}

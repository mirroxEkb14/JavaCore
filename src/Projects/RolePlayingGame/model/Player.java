package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.Kind;

    /*
        This class contains all the necessary fields and methods
        for players. Each player will be inherited from this class
     */

public abstract class Player {

    private final String nickName;
    private final String kind;
    private int hp = 100;
    private int force;
    private int agility;
    private int xp = 0;
    private int gold = 0;

    public Player(String nickName, String kind) {
        this.nickName = nickName;
        this.kind = kind;

        if (kind.equals(Kind.AGILITY)) {
            // if the user chose 'agility' kind
            agility = 25;
            force = 20;
        } else {
            // if 'force' kind
            agility = 20;
            force = 25;
        }
    }

    public void attack(Entity entity) {
        entity.setHp(entity.getHp() - this.getForce());
    }

    public int getHp() {
        return hp;
    }

    public int getForce() {
        return force;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

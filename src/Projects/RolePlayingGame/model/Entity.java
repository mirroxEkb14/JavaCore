package Projects.RolePlayingGame.model;

public abstract class Entity {

    /*
        All entities except the player will be
        inherited from this class
     */

    private int hp;
    private int force;
    private int agility;

    public Entity(int hp, int force, int agility) {
        this.hp = hp;
        this.force = force;
        this.agility = agility;
    }

    public void attack(Player player) {
        player.setHp(player.getHp() - this.getForce());
    }

    public int getHp() {
        return hp;
    }

    public int getForce() {
        return force;
    }

    public void setHp(int hp) {
        if (this.getHp() <= 0) System.out.println("");
        this.hp = hp;
    }
}

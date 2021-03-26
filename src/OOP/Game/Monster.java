package OOP.Game;

public class Monster {

    private String kind;
    private int hp;
    private int damage;

    public Monster(String kind, int hp, int damage) {
        this.kind = kind;
        this.hp = hp;
        this.damage = damage;
    }

    public String getKind() {
        return this.kind;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHp() {
        return this.hp;
    }

    /*  make check: if monster`s hp(who is under attack - m2) <= 0, this monster is defeated;
        if not, we subtract the amount of monster damage who attacks from m2-monster HP(who is under attack) */
    public void setHp(int hp) {
        if (this.getHp() > 0) {
            this.hp = hp;
        } else {
            System.out.printf("\nThe '%s' is defeated\n", this.getKind());
        }
    }

    /* This method takes one arguments: m2 - monster who is under attack;
    *   we use 'set' method that takes one arguments:
        subtraction of monster`s hp who is under attack and monster damage who attacks */

    public void attack(Monster m2) {
        m2.setHp(m2.getHp() - this.getDamage());
    }
}


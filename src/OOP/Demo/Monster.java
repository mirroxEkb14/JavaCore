package OOP.Demo;

public class Monster {

    private String kind;
    private int damage;

    public Monster(String kind, int damage) {
        this.kind = kind;
        this.damage = damage;
    }

    public String getKind() {
        return this.kind;
    }

    public int getDamage() {
        return this.damage;
    }

    public void growl() {
        System.out.println(" the Monster " + this.kind + " is growling");
    }

    public void attack() {
        System.out.println("The Monster " + this.kind + " attacked with damage " + this.damage);
    }
}

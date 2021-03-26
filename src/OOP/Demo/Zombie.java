package OOP.Demo;

public class Zombie extends Monster {

    public Zombie(int damage) {
        super("Zombie", damage);
    }

    @Override
    public void growl() {
        System.out.print("Raaaaauuugh");
        super.growl();
    }

    // Overloading
    public void growl(boolean loud) {
        if (loud) System.out.print("RAAAAUUUGH");
        super.growl();
    }
}

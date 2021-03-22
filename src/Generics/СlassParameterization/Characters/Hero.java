package Generics.СlassParameterization.Characters;

import Generics.СlassParameterization.WeaponsInterfaces.Weapon;

public class Hero<T extends Weapon> {

    /*  With <T> in class signature we can pass any type of weapon we want.
            We also need to parameterize the other "Hero" classes(Archer, Warrior, Mage) using "<T>" because
            when we create them, we pass the type we want:

        Archer<Bow> ...;
        Warrior<Sword> ...;
        Mage<Wand> ...;

        *see the "WeaponRunner" class */

    private final String name;
    private final int damage;
    private T weapon;

    public Hero(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }
}

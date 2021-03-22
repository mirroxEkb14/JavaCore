package Generics.MethodParameterization.Characters;

import Generics.MethodParameterization.WeaponsInterfaces.Weapon;

public class Hero<T extends Weapon> {

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

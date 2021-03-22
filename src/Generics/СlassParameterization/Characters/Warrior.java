package Generics.СlassParameterization.Characters;

import Generics.СlassParameterization.WeaponsInterfaces.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(String name, int damage) {
        super(name, damage);
    }
}

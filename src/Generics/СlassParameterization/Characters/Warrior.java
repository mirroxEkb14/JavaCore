package Generics.–°lassParameterization.Characters;

import Generics.–°lassParameterization.WeaponsInterfaces.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(String name, int damage) {
        super(name, damage);
    }
}

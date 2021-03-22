package Generics.MethodParameterization.Characters;

import Generics.MethodParameterization.WeaponsInterfaces.MeleeWeapon;

public class Warrior<T extends MeleeWeapon> extends Hero<T> {

    public Warrior(String name, int damage) {
        super(name, damage);
    }
}

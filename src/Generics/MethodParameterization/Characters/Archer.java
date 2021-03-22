package Generics.MethodParameterization.Characters;

import Generics.MethodParameterization.WeaponsInterfaces.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T> {

    public Archer(String name, int damage) {
        super(name, damage);
    }
}

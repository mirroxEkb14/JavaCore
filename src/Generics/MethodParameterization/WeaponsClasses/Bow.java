package Generics.MethodParameterization.WeaponsClasses;

import Generics.MethodParameterization.WeaponsInterfaces.RangeWeapon;

public class Bow implements RangeWeapon {

    @Override
    public int getDamage() {
        return 5;
    }
}

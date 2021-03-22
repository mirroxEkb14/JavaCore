package Generics.СlassParameterization.WeaponsClasses;

import Generics.СlassParameterization.WeaponsInterfaces.RangeWeapon;

public class Bow implements RangeWeapon {

    @Override
    public int getDamage() {
        return 5;
    }
}

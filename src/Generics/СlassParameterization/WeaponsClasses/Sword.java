package Generics.СlassParameterization.WeaponsClasses;

import Generics.СlassParameterization.WeaponsInterfaces.MeleeWeapon;

public class Sword implements MeleeWeapon {

    @Override
    public int getDamage() {
        return 10;
    }
}

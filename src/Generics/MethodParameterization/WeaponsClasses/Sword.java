package Generics.MethodParameterization.WeaponsClasses;

import Generics.MethodParameterization.WeaponsInterfaces.MeleeWeapon;

public class Sword implements MeleeWeapon {

    @Override
    public int getDamage() {
        return 10;
    }
}

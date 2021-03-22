package Generics.MethodParameterization;

import Generics.MethodParameterization.Characters.Archer;
import Generics.MethodParameterization.Characters.Hero;
import Generics.MethodParameterization.Characters.Warrior;
import Generics.MethodParameterization.WeaponsClasses.Bow;
import Generics.MethodParameterization.WeaponsClasses.Sword;
import Generics.MethodParameterization.WeaponsInterfaces.Weapon;

public class WeaponRunner {

    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Archer", 5);
        Warrior<Sword> warrior = new Warrior<>("Warrior", 10);

        printWeaponDamage(archer);
        printWeaponDamage(warrior);
    }

    /*  Our "Hero" class is parameterized, so we need to specify Generic type, but which one?
            for example, we specify the "Sword" type, then we can pass our warrior to this method (Hero<Sword> hero):
                printWeaponDamage(warrior)

            but: printWeaponDamage(archer) -> compilation error

            even if: (Hero<Weapon> hero);
                     printWeaponDamage(archer) -> compilation error

            Why? Hero is an Archer (extends RangeWeapon) or a Warrior (extends MeleeWeapon), so
                must pass the type that we specified earlier.
                It will work:
                    printWeaponDamage(Hero<Bow> hero) -> printWeaponDamage(archer);
                    printWeaponDamage(Hero<Sword> hero) -> printWeaponDamage(warrior);

                It will not work:
                    printWeaponDamage(Hero<Weapon> hero) -> printWeaponDamage(archer);
                    printWeaponDamage(Hero<Weapon> hero) -> printWeaponDamage(warrior);

                    because earlier we specified:
                        Archer<Bow> archer = ...;
                        Warrior<Sword> warrior = ...;


            With method parameterization we specify that some "<T>" type will be passed to the method:
                public static void printWeaponDamage(Hero<T> hero)

                But what type? Because our "Hero" class takes not every type:
                    public class Hero<T>

                    but:
                        public class Hero<T extends Weapon>

                    we have to limit the types:
                        public static <T extends Weapon> void printWeaponDamage(Hero<T> hero)


                With wildCard: public static void printWeaponDamage(Hero<? extends Weapon> hero)  */

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero) {
        System.out.println(hero.getDamage());
    }
}

package WorldPackage;

import MainClassesAndOther.PlayerUnit;
import PlayerClases.Rogue;
import PlayerClases.Warrior;

import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) {
        PlayerUnit playerHero = HeroCreated.create();

        System.out.println("Hello " + playerHero + "! Let's begin your journey!");
        playerHero.printCharInfo();
        playerHero.lvlUp(3);
        playerHero.printPlayerExp();
        playerHero.takeExp(233);
        playerHero.printCharInfo();
        playerHero.lvlUp(33);
        playerHero.printCharInfo();

    }
}

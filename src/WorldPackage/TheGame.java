package WorldPackage;

import MainClassesAndOther.PlayerUnit;
import MonsterClasses.Goblin;
import MonsterClasses.Skeleton;

import java.util.Random;
import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) {

        PlayerUnit playerHero = HeroCreated.create();

        System.out.println("Hello " + playerHero + "! Let's begin your journey!");
        playerHero.printCharInfo();

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhere do you want to go?\n" +
                "1. To the trader\n" +
                "2. To the dark forest.\n" +
                "3. the exit");
        while (true) {
            String scan = sc.nextLine();
            if (scan.equals("1") || scan.toLowerCase().equals("trader")) {
                tradeWithTrader();
            } else if (scan.equals("2") || scan.toLowerCase().equals("dark forest")) {
                battleInDarkForest(playerHero);
            } else if (scan.equals("3") || scan.toLowerCase().equals("exit")) {
                break;
            }


        }




    }

    private static void tradeWithTrader() {
        System.out.println("The trader has not yet come to work");
    }

    private static void battleInDarkForest(PlayerUnit playerHero) {
        playerHero.startFight(
                isaBoolean() ?
                new Skeleton(playerHero) : 
                new Goblin(playerHero));

        System.out.println("\nWhere do you want to go?\n" + 
                "1. Return to town\n" +
                "2. Continue fighting");
    }

    private static boolean isaBoolean() {
        return new Random().nextInt(1, 3) == 1;
    }
}

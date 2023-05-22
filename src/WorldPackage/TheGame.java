package WorldPackage;

import MainClassesAndOther.MonsterUnit;
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

        System.out.println("\nWhere do you want to go?\n" +
                "1. To the trader.\n" +
                "2. To the dark forest.\n" +
                "3. Exit the game.");

        Scanner sc = new Scanner(System.in);
        String nextScan = "";
        do {
            nextScan = sc.nextLine();
            if ("1".equals(nextScan)) {
                tradeWithTrader();
                continue;
            } else if ("2".equals(nextScan)) {
                battleInDarkForest(playerHero);
                continue;
            } else if ("3".equals(nextScan)) {
                break;
            } else System.out.println("Please enter where do you want to go?");

        } while (!"3".equals(nextScan));

    }

    private static void tradeWithTrader() {
        System.out.println("The trader has not yet come to work");
    }

    private static void battleInDarkForest(PlayerUnit playerHero) {
        playerHero.printCharInfo();
        MonsterUnit monsterUnit = isaBoolean() ?
                new Skeleton(playerHero) :
                new Goblin(playerHero);
        monsterUnit.printMonsterInfo();
        Battle battle = Battle.startTheBattle(playerHero, monsterUnit);
        System.out.println(battle); //ПРОИГРЫШ

        System.out.println("\nWhere do you want to go?\n" +
                "1. Return to town, for trade.\n" +
                "2. Continue fighting.\n" +
                "3. Exit the game.");
    }

    private static boolean isaBoolean() {
        return new Random().nextInt(1, 3) == 1;
    }
}

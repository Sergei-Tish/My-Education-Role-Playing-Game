package WorldPackage;

import MainClassesAndOther.MonsterUnit;
import MainClassesAndOther.PlayerUnit;
import MonsterClasses.Goblin;
import MonsterClasses.Skeleton;

import java.util.Random;
import java.util.Scanner;

public class TheGame {

    public static PlayerUnit playerHero;

    public static void main(String[] args) {
        while (true) {

            playerHero = HeroCreated.create();

            System.out.println("Hello " + playerHero + "! Let's begin your journey!");
            playerHero.printCharInfo();

            System.out.println("\nWhere do you want to go?\n" +
                    "1. To the trader.\n" +
                    "2. To the dark forest.\n" +
                    "3. Exit the game.");

            Scanner sc = new Scanner(System.in);
            String nextScan = "";

            chooseYourPath(playerHero);

            System.out.println("GAME OVER\n" +
                    "\n" +
                    "RESTART GAME? \"Y/N\"");
            nextScan = sc.nextLine();
            if (nextScan.equals("Y")) {
                continue;
            } else break;
        }
    }

    private static void chooseYourPath(PlayerUnit playerHero) {
        Scanner sc = new Scanner(System.in);
        String nextScan;
        do {
            nextScan = sc.nextLine();
            if ("1".equals(nextScan)) {
                tradeWithTrader(playerHero);
                continue;
            } else if ("2".equals(nextScan)) {
                playerHero.heroIsLive = battleInDarkForest(playerHero);
                if (!playerHero.heroIsLive) break;
                continue;
            } else if ("3".equals(nextScan)) {
                break;
            } else if ("help".equalsIgnoreCase(nextScan)) {
                System.out.println("the Game have next command:\n" +
                        "Gold - show your gold\n" +
                        "Stats - show your HP and Exp");
            } else if ("Gold".equalsIgnoreCase(nextScan)) {
                System.out.println("You have " + playerHero.getGold() + " gold.");
            } else if ("Stats".equalsIgnoreCase(nextScan)) {
                printStatsHero(playerHero);
            } else if ("info".equalsIgnoreCase(nextScan)) {
                playerHero.printCharInfo();
            } else System.out.println("Please enter where do you want to go?");
        } while (!"3".equals(nextScan));
    }

    private static void tradeWithTrader(PlayerUnit playerHero) {


        System.out.println("The trader has not yet come to work".toUpperCase());
        System.out.println("\nWhere do you want to go?\n" +
                "1. Return to trader.\n" +
                "2. To the dark forest.\n" +
                "3. Exit the game.");
    }

    public static MonsterUnit monsterUnit;

    //    private static boolean oldBattleInDarkForest(PlayerUnit playerHero) {
////        playerHero.printCharInfo();
//        MonsterUnit monsterUnit = isaBoolean() ?
//                new Skeleton(playerHero) :
//                new Goblin(playerHero);
//        monsterUnit.printMonsterInfo();
//        OldBattle oldBattle = OldBattle.startBattle(playerHero, monsterUnit);
//        if (oldBattle.heroIsWin) {
//            System.out.println(oldBattle.toStringWin());
//            playerHero.takeExp(monsterUnit.getAwardExp());
//            printStatsHero(playerHero);
//
//            System.out.println("\nWhere do you want to go?\n" +
//                    "1. Return to town, for trade.\n" +
//                    "2. Continue fighting.\n" +
//                    "3. Exit the game.");
//        } else {
//            System.out.println(oldBattle.toStringLose()); //ПРОИГРЫШ
//        }
//        return oldBattle.heroIsWin;
//    }
    private static boolean battleInDarkForest(PlayerUnit playerHero) {
//        playerHero.printCharInfo();
        monsterUnit = isaBoolean() ?
                new Skeleton(playerHero) :
                new Goblin(playerHero);
        monsterUnit.printMonsterInfo();
        Thread threadBattle = new Battle();
        threadBattle.start();
        try {
            threadBattle.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (playerHero.heroIsLive) {
            playerHero.takeExp(monsterUnit.getAwardExp());

            printStatsHero(playerHero);
            System.out.println("\nWhere do you want to go?\n" +
                    "1. Return to town, for trade.\n" +
                    "2. Continue fighting.\n" +
                    "3. Exit the game.");
        }
        return playerHero.heroIsLive;
    }


    private static void printStatsHero(PlayerUnit playerHero) {
        System.out.println("Your stats: \n" +
                "Hit points = " + playerHero.getCurrentHP() + "/" + playerHero.getMaxHP() + ".\n" +
                "Experience = " + playerHero.getCurrentExp() + "/" + playerHero.getRequiredExp() + ". Need " + (playerHero.getRequiredExp() - playerHero.getCurrentExp()) + " exp to level " + (playerHero.getLevel() + 1) + ".");
    }

    private static boolean isaBoolean() {
        return new Random().nextInt(1, 3) == 1;
    }
}

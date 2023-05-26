package WorldPackage;

import MainClassesAndOther.MonsterUnit;
import MainClassesAndOther.PlayerUnit;

public class Battle extends Thread {

    public Battle () {

    }

    public static PlayerUnit playerUnitStatic;
    public static MonsterUnit monsterUnitStatic;

    public void run() {

        int countHitsOfHero = 0;
        int countOfHeroDamage = 0;
        int countHeroMiss = 0;

        int countHitsOfMonster = 0;
        int countOfMonsterDamage = 0;
        int countMonsterMiss = 0;

        while (true) {
            if (TheGame.playerHero.getHitOrMiss()) {
                int hitDamage = TheGame.playerHero.getHitDamage();

                countHitsOfHero++;
                countOfHeroDamage += hitDamage;

                TheGame.monsterUnit.takeDamage(hitDamage);
                if (TheGame.monsterUnit.getCurrentHP() <= 0) {
                    TheGame.playerHero.heroIsLive = true;
                    TheGame.playerHero.plusGold(TheGame.monsterUnit.getAwardGold());
                    break;
                }
            } else countHeroMiss++;

            if (TheGame.monsterUnit.getHitOrMiss()) {
                int hitDamage = TheGame.monsterUnit.getHitDamage();

                countHitsOfMonster++;
                countOfMonsterDamage += hitDamage;

                TheGame.playerHero.takeDamage(hitDamage);
                if (TheGame.playerHero.getCurrentHP() <= 0) {
                    TheGame.playerHero.heroIsLive = false;
                    break;
                }
            } else countMonsterMiss++;
        }

        System.out.println(
                "The battle results: \n" +
                        "The " + TheGame.playerHero.getClassName() + " \"" + TheGame.playerHero.getName() + "\" hits " + countHitsOfHero + " times and deals " + countOfHeroDamage + " damage. " +
                        "Missed " + countHeroMiss + " times.\n" +
                        "The " + TheGame.monsterUnit.getClassName() + " hits " + countHitsOfMonster + " times and deals " + countOfMonsterDamage + " damage. " +
                        "Missed " + countMonsterMiss + " times."
        );
        if (TheGame.playerHero.heroIsLive) {
            System.out.println(
                    "\"" + TheGame.playerHero.getName() + "\" take " + TheGame.monsterUnit.getAwardExp() + " exp, and " + TheGame.monsterUnit.getAwardGold() + " gold."
            );
        } else {
            System.out.println(
                    "\"" + TheGame.playerHero.getName().toUpperCase() + "\" DIED AT LEVEL " + TheGame.playerHero.getLevel() + "."
            );
        }

    }
}

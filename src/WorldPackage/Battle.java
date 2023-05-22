package WorldPackage;

import MainClassesAndOther.MonsterUnit;
import MainClassesAndOther.PlayerUnit;

public class Battle {
    int countHeroHit = 0;
    int countHeroDamage = 0;
    int countMonsterHit = 0;
    int countMonsterDamage = 0;
    boolean heroIsWin = true;
    PlayerUnit playerUnit;
    MonsterUnit monsterUnit;

    public Battle(int hHits, int hDamage, int mHits, int mDamage, boolean heroIsWin, PlayerUnit playerHero, MonsterUnit monster) {
        this.countHeroHit = hHits;
        this.countHeroDamage = hDamage;
        this.countMonsterHit = mHits;
        this.countMonsterDamage = mDamage;
        this.playerUnit = playerHero;
        this.monsterUnit = monster;
    }
    public String toString() {
        return "The battle results: \n" +
                "The " + playerUnit.getClassName() + " \"" + playerUnit.getName() + "\" hits " + countHeroHit + " times and deals " + countHeroDamage + " damage.\n" +
                "The " + monsterUnit.getClassName() + " hits " + countMonsterHit + " times and deals " + countMonsterDamage + " damage.\n" +
                "\"" + playerUnit.getName() + "\" take " + monsterUnit.getAwardExp() + " exp, and " + monsterUnit.getAwardGold() + " gold.\n" +
                "Hit points = " + playerUnit.getCurrentHP() + "/" + playerUnit.getMaxHP() + ".\n" +
                "Experience = " + playerUnit.getCurrentExp() + "/" + playerUnit.getRequiredExp() + ".";
    }


    public static Battle startTheBattle(PlayerUnit playerHero, MonsterUnit monster) {

        int countHitsOfHero = 0;
        int countOfHeroDamage = 0;

        int countHitsOfMonster = 0;
        int countOfMonsterDamage = 0;
        boolean heroIsWin = true;

        while (true) {
            if (playerHero.getHitOrMiss()) {
                int hitDamage = playerHero.getHitDamage();

                countHitsOfHero++;
                countOfHeroDamage += hitDamage;

                monster.takeDamage(hitDamage);
                if (monster.getCurrentHP() <= 0) {
                    heroIsWin = true;
                    playerHero.takeExp(monster.getAwardExp());
                    playerHero.plusGold(monster.getAwardGold());
                    break;
                }
            }

            if (monster.getHitOrMiss()) {
                int hitDamage = monster.getHitDamage();

                countHitsOfMonster++;
                countOfMonsterDamage += hitDamage;

                playerHero.takeDamage(hitDamage);
                if (playerHero.getCurrentHP() <= 0) {
                    heroIsWin = false;
                    break;
                }
            }
        }
        return new Battle(countHitsOfHero, countOfHeroDamage, countHitsOfMonster, countOfMonsterDamage, heroIsWin, playerHero, monster);
    }
}

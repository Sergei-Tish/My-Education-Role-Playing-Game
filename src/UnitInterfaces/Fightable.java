package UnitInterfaces;

import MainClassesAndOther.MonsterUnit;

import java.util.Random;

public interface Fightable {
    Random random = new Random();

    default int getHitDamage() {
        int damage = random.nextInt(5,10) + (getStrength() * 3 / 2);
        return damage;
    }
    int getStrength();
    int getAgility();


    default boolean getHitOrMiss() { //расчёт шанса попадания
        int chance = random.nextInt(1, 101) + (getAgility() * 5 / 2);
        // if (ag = 1) 2.5-102.5, // if (ag = 20) 50-150
        return chance > 50;
    }

    default int getChanceToHit() {
        return 50 + (getAgility() * 5 / 2);
    }

    default boolean getHitOrMiss(int intBuffOrNerfChance) { //расчёт шанса попадания + добавить плюсы или минусы контретного удара
        Random random = new Random();
        int chance = random.nextInt(101) + (getAgility() * 5 / 2)
                + intBuffOrNerfChance;
        return chance > 50;
    }

    void startFight(MonsterUnit enemy);
}

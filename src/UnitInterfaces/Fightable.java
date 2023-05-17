package UnitInterfaces;

import java.util.Random;

public interface Fightable {
    Random random = new Random();
    void startFight(Fightable enemy);
    default int getHitDamage() {
        int damage = random.nextInt(5,10) + (getStrength() * 3 / 2);
        return damage;
    }
    int getStrength();
    int getAgility();


    default boolean getHitOrMiss() { //расчёт шанса попадания
        Random random = new Random();
        int chance = random.nextInt(101) + (getAgility() * 5 / 2);
        // if (ag = 1) 2.5-102.5, // if (ag = 20) 50-150
        return chance > 50;
    }
    default boolean getHitOrMiss(int intBuffOrNerfChance) { //расчёт шанса попадания + добавить плюсы или минусы контретного удара
        Random random = new Random();
        int chance = random.nextInt(101) + (getAgility() * 5 / 2)
                + intBuffOrNerfChance;
        return chance > 50;
    }
}

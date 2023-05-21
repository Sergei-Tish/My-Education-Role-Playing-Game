package MonsterClasses;

import MainClassesAndOther.MonsterUnit;
import MainClassesAndOther.PlayerUnit;
import UnitInterfaces.Fightable;

import java.util.Random;

public class Goblin extends MonsterUnit {

    String name = "Goblin";
    String className = "Goblin";
    private int strength = 8;
    private int agility = 8;
    //    private int intelligence = 8;
    //    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();
    private int level = 1;

    private int awardExp;
    private int awardGold;
    private static int countOfGoblin = 0;

    public Goblin(PlayerUnit hero) {
        this.name = "goblin_#" + ++countOfGoblin;
        this.strength = hero.getStrength() * 2 / 3;
        this.agility = hero.getAgility() * 3 / 4;
        this.maxHP = this.strength * (new Random().nextInt(8, 13));
        this.currentHP = this.maxHP;
        this.level = hero.getLevel() * 5 / 6;
        this.awardExp = hero.expForLvl(hero.getLevel()) / hero.getLevel() * 11 / 10;
        this.awardGold = this.level * (new Random().nextInt(10, 15));
    }


    @Override
    public void startFight(Fightable enemy) {

    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public int getAgility() {
        return 0;
    }

    @Override
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getCurrentHP() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }

    public String getName() {
        return name;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public int getAwardExp() {
        return awardExp;
    }

    public int getAwardGold() {
        return awardGold;
    }

    public static int getCountOfGoblin() {
        return countOfGoblin;
    }
}

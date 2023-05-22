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
        super(hero);
        this.name = "goblin_#" + ++countOfGoblin;
        this.strength = 1 + hero.getStrength() * 2 / 3;
        this.agility = 1 + hero.getAgility() * 3 / 4;
        this.maxHP = this.strength * (new Random().nextInt(8, 13));
        this.currentHP = this.maxHP;
        this.level = hero.getLevel() <= 1 ? 1 :
                hero.getLevel() * 5 / 6;
        this.awardExp = hero.expForLvl(hero.getLevel()) / hero.getLevel() * 11 / 10;
        this.awardGold = this.level * (new Random().nextInt(10, 15));
    }

    public void printMonsterInfo() {
        System.out.println(
                "Character \"" + getName() + "\" level " + getLevel() + " " + getClassName() + ".\n" +
                        "Hit points = " + getCurrentHP() + "/" + getMaxHP() + ".\n" +
                        "Strength = " + getStrength() + ", hit damage = " + getHitDamage() + ".\n" +
                        "Agility = " + getAgility() + ", hit chance = " + getChanceToHit() + ".\n"
        );
    }

    @Override
    public void startFight(Fightable enemy) {

    }
    @Override
    public void startFight(MonsterUnit enemy) {

    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getCurrentHP() {
        return currentHP;
    }

    @Override
    public void takeDamage(int damage) {
        currentHP -= damage;
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

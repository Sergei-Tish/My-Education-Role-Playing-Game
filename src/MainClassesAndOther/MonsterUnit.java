package MainClassesAndOther;

import UnitInterfaces.Fightable;

import java.util.Random;

public abstract class MonsterUnit extends FighterUnit {

    String name = "Monster";
    String className = "MonsterUnit";
    private int strength = 8;
    private int agility = 8;
//    private int intelligence = 8;
//    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();
    private int level = 1;
    private int awardExp;
    private int awardGold;
    private int countOfMonster;

    public MonsterUnit(PlayerUnit hero) {
        this.name = "monster_" + ++countOfMonster;
        this.strength = 1 + hero.getStrength() * 2 / 3;
        this.agility = 1 + hero.getAgility() * 3 / 4;
        this.maxHP = this.strength * (new Random().nextInt(8, 13));
        this.currentHP = this.maxHP;
        this.level = hero.getLevel() <= 1 ? 1 :
                hero.getLevel() * 5 / 6;
        this.awardExp = hero.expForLvl(hero.getLevel()) / hero.getLevel() * 11 / 10;
        this.awardGold = this.level * (new Random().nextInt(10, 15));
    }

    public abstract void startFight(Fightable enemy);

    public void printMonsterInfo() {
        System.out.println(
                "You have met the monster \"" + getName() + "\" level " + getLevel() + " " + getClassName() + " with " + getMaxHP() + "HP.\n" +
                        "Strength = " + getStrength() + ", hit damage = " + getHitDamage() + ".\n" +
                        "Agility = " + getAgility() + ", hit chance = " + getChanceToHit() + ".\n"
        );
    }

    public String getName() {
        return name;
    }

    @Override
    public String getClassName() {
        return className;
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
    public int getLevel() {
        return level;
    }

    public int getAwardExp() {
        return awardExp;
    }

    public int getAwardGold() {
        return awardGold;
    }

    public int getCountOfMonster() {
        return countOfMonster;
    }
}

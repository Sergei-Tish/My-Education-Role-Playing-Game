package MonsterClasses;

import MainClassesAndOther.MonsterUnit;
import MainClassesAndOther.PlayerUnit;
import PlayerClases.Warrior;
import UnitInterfaces.Fightable;

import java.util.Random;

public class Skeleton extends MonsterUnit {

    String name = "Skeleton";
    String className = "Skeleton";
    private int strength = 8;
    private int agility = 8;
    //    private int intelligence = 8;
//    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();
    private int level = 1;

    private int awardExp;
    private int awardGold;
    private static int countOfSkeleton = 0;

    public Skeleton(PlayerUnit hero) {
        super(hero);
        this.name = "skeleton_#" + ++countOfSkeleton;
        this.strength = 1 + hero.getStrength() * 2 / 3;
        this.agility = 1 + hero.getAgility() * 3 / 4;
        this.maxHP = this.strength * (new Random().nextInt(8, 13));
        this.currentHP = this.maxHP;
        this.level = hero.getLevel() <= 1 ? 1 :
                hero.getLevel() * 5 / 6;
        this.awardExp = hero.expForLvl(hero.getLevel()) / hero.getLevel();
        this.awardGold = this.level * (new Random().nextInt(8, 13));
    }
    public Skeleton(PlayerUnit hero, int forTest) {
        super(hero);
        this.name = "skeleton_#" + ++countOfSkeleton;
        this.strength = 1 + (hero.getStrength() * 2 / 3);         System.out.println(1 + (hero.getStrength() * 2 / 3));
        this.agility = 1 + (hero.getAgility() * 3 / 4);        System.out.println(1 + (hero.getAgility() * 3 / 4));
        this.maxHP = this.strength * (new Random().nextInt(8, 13));        System.out.println(this.strength * (new Random().nextInt(8, 13)));
        this.currentHP = this.maxHP;
        this.level = hero.getLevel() * 5 / 6;
        this.awardExp = hero.expForLvl(hero.getLevel()) / hero.getLevel();
        this.awardGold = this.level * (new Random().nextInt(8, 13));
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

    public static int getCountOfSkeleton() {
        return countOfSkeleton;
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

}

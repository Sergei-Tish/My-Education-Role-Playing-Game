package MainClassesAndOther;

import UnitInterfaces.*;
import WorldPackage.Battle;

import java.util.Random;

public abstract class PlayerUnit
        extends FighterUnit
        implements Playerable, Experienceable, Nameable {

    String name = "Player";
    String className = "PlayerUnit";
    private int strength = 8;
    private int agility = 8;
    private int intelligence = 8;
    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();
    private int level = 1;

    @Override
    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public int getGold() {
        return super.getGold();
    }

    @Override
    public void minusGold(int howMuch) {
        super.minusGold(howMuch);
    }

    @Override
    public void plusGold(int howMuch) {
        super.plusGold(howMuch);
    }

    @Override
    public int getHitDamage() {
        return super.getHitDamage();
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
    public boolean getHitOrMiss() {
        return super.getHitOrMiss();
    }

    @Override
    public boolean getHitOrMiss(int intBuffOrNerfChance) {
        return super.getHitOrMiss(intBuffOrNerfChance);
    }

    @Override
    public boolean playerCharacter() {
        return Playerable.super.playerCharacter();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void lvlUp(int numberOfLevel) {
        super.lvlUp(numberOfLevel);
        increaseCharacteristicFroLvlUp();
    }

    @Override
    public void lvlUp() {
        if (level != 1) takeExp(expForLvl(level));
        else takeExp(100);
        increaseCharacteristicFroLvlUp();
    }

    private int currentExp = 0;

    public int expForLvl(int atLevel) {
        int result = 100;
        for (int i = 1; i < atLevel; i++) {
            result = result * 3 / 2;
        }
        return result;
    }

    private int expForLvl(int atLevel, int atLevel1) { // если будем выдавать сразу высокий уровень
        if (atLevel < 4) {
            int result = 0;
            for (int i = 0; i < atLevel; i++) result += expForLvl(i);
            return result;
        } else {
            return (int) (expForLvl(atLevel - 1) + (expForLvl(atLevel - 1) - expForLvl(atLevel - 2)) * 1.5);
        }
    }

    private int requiredExp = level == 1 ? 100 : expForLvl(level, level);

    @Override
    public int getCurrentExp() {
        return currentExp;
    }

    @Override
    public int getRequiredExp() {
        return requiredExp;
    }

    public abstract void printPlayerExp();


    @Override
    public void takeExp(int howMuchExp) {
        System.out.println("\"" + getName() + "\" take " + howMuchExp + " experience");
        currentExp += howMuchExp;
        if (currentExp >= requiredExp) {
            level++;
            increaseCharacteristicFroLvlUp();
            requiredExp += expForLvl(level);
        }
    }

    public void increaseCharacteristicFroLvlUp() {
        if (getLevel() % 3 == 0) {
            if (new Random().nextInt(1, 3) == 1) {
                this.strength++;
            } else this.agility++;
        }
        this.maxHP += 10;
        currentHP = maxHP;
    }

    @Override
    public String toString() {
        return "\"" + getName() + "\" the " + getClassName() + " at level " + getLevel();
    }



    public void printCharInfo() {
        System.out.println(
                "Character \"" + getName() + "\" level " + getLevel() + " " + getClassName() + ".\n" +
                        "Hit points = " + getCurrentHP() + "/" + getMaxHP() + ".\n" +
                        "Strength = " + getStrength() + ", hit damage = " + getHitDamage() + ".\n" +
                        "Agility = " + getAgility() + ", hit chance = " + getChanceToHit() + ".\n" +
                        "Experience = " + getCurrentExp() + "/" + getRequiredExp() + "."
        );
    }

    @Override
    public void startFight(MonsterUnit enemy) {
        Battle.startBattle(this, enemy);
    }
}

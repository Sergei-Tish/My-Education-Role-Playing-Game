package PlayerClases;

import MainClassesAndOther.PlayerUnit;
import UnitInterfaces.Fightable;

public class Warrior extends PlayerUnit {
    private String name = "Unnamed hero";
    private String className = "Warrior";
    private int strength = 8;
    private int agility = 8;
    private int intelligence = 8;
    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();


    public Warrior(String name, int strength, int agility) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.maxHP = 50 + ((this.strength - 8) * 5);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "\"" + getName() + "\" the " + getClassName() + " at level " + getLevel();
    }

    @Override
    public void startFight(Fightable enemy) {

    }
    public void printCharInfo() {
        System.out.println(
                "\"" + getName() + "\" level " + getLevel() + " " + getClassName() + ".\n" +
                        "Hit points = " + getCurrentHP() + "/" + getMaxHP() + ".\n" +
                        "Strength = " + getStrength() + ".\n" +
                        "Agility = " + getAgility() + ".\n" +
                        "Experience = " + getCurrentExp() + "/" + getRequiredExp()
        );
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




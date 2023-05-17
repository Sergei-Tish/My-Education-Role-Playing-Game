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


    public Warrior(String name, int strangeBonus, int agilityBonus) {
        this.name = name;
        this.strength += 4 + strangeBonus;
        this.agility += 2 + agilityBonus;
        this.maxHP = 50 + ((strangeBonus + 4) * 5);
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
        return "\"" + getName() + "\" level " + getLevel() + " " + getClassName();
    }

    @Override
    public void startFight(Fightable enemy) {

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
    public void takeDamage() {

    }
}




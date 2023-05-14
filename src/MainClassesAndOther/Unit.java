package MainClassesAndOther;

import UnitInterfaces.GoldInterface;
import UnitInterfaces.Levelable;

public abstract class Unit implements GoldInterface, Levelable {
    private int level = 1;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void lvlUp() {
        level++;
    }
    String className = "Unit";
    private int gold = 0;

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void minusGold(int howMuch) {
        if (getGold() >= howMuch) {
            gold -= howMuch;
        } else {
            gold = 0;
        }
    }

    @Override
    public void plusGold(int howMuch) {
        gold += howMuch;
    }


    @Override
    public String toString() {
        return "I'm a " + className;
    }

    public String getClassName() {
        return className;
    }
}

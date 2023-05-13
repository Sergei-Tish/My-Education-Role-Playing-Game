package PlayerClases;

import UnitInterfaces.GoldInterface;

public class Warrior implements GoldInterface {
    String className = "Warrior";
    private int gold = 0;

    @Override
    public void minusGold(int howMuch) {
        gold = getGold() - howMuch;
    }

    @Override
    public void plusGold(int howMuch) {
        gold = getGold() + howMuch;
    }


    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        return "I'm a " + className;
    }
}




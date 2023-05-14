package MainClassesAndOther;

import UnitInterfaces.*;

public abstract class PlayerUnit
        extends FighterUnit
        implements Playerable, Experienceable, Nameable {

    String name = "Unnamed player hero";
    String className = "PlayerUnit";

    private int level = 1;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void lvlUp() {
        if (level != 1) {
            takeExp(expForLvl(level));
        } else takeExp(100);
    }

    private int currentExp = 0;

    private int expForLvl(int atLevel) {
        int result = 100;
        for (int i = 1; i < atLevel; i++) {
            result = result * 3 / 2;
        }
        return result;
    }

    private int expForLvl(int atLevel, char ch) { // если будем выдавать сразу высокий уровень
        if (atLevel < 4) {
            int result = 0;
            for (int i = 0; i < atLevel; i++) {
                result += expForLvl(i);
            }
            return result;
        } else {
            return (int) (expForLvl(atLevel - 1) + (expForLvl(atLevel - 1) - expForLvl(atLevel - 2)) * 1.5);

        }
    }


    private int requiredExp = level == 1 ? 100 : expForLvl(level, 'a');

    @Override
    public int getCurrentExp() {
        return currentExp;
    }

    @Override
    public int getRequiredExp() {
        return requiredExp;
    }


    public static void printPlayerExp(PlayerUnit playerUnit) {
        System.out.printf("\"%s\" the %s at level %d have %d\\%d exp, and me need %d for level %d%n", ((Nameable) playerUnit).getName(), playerUnit.getClassName(), playerUnit.getLevel(), playerUnit.getCurrentExp(), playerUnit.getRequiredExp(), playerUnit.getRequiredExp() - playerUnit.getCurrentExp(), (playerUnit.getLevel() + 1));

    }


    @Override
    public void takeExp(int howMuchExp) {
        System.out.println(this.name + " take " + howMuchExp + " experience");
        currentExp += howMuchExp;
        if (currentExp >= requiredExp) {
            level++;
            requiredExp += expForLvl(level);
        }
    }


    @Override
    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

}

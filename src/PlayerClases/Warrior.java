package PlayerClases;

import MainClassesAndOther.PlayerUnit;
import UnitInterfaces.GoldInterface;

public class Warrior extends PlayerUnit {
    private String className = "Warrior";

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "I'm a \"" + getName() + "\" level " + getLevel() + " " + getClassName();
    }
}




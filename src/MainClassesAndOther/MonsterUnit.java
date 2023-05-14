package MainClassesAndOther;

import UnitInterfaces.Fightable;
import UnitInterfaces.HPInterface;

public abstract class MonsterUnit extends FighterUnit implements Fightable, HPInterface {
    private int Level = 1;

}

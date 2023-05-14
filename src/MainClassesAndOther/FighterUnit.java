package MainClassesAndOther;

import UnitInterfaces.Fightable;
import UnitInterfaces.HPInterface;

public class FighterUnit extends Unit implements HPInterface, Fightable {
    @Override
    public void startFight(Fightable enemy) {

    }

    @Override
    public int getMaxHP() {
        return 0;
    }

    @Override
    public int getCurrentHP() {
        return 0;
    }

    @Override
    public void takeDamage() {

    }
}

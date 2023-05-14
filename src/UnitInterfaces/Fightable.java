package UnitInterfaces;

public interface Fightable {
    void startFight(Fightable enemy);
    int getHitDamage();
    default int getHitChance() {

    }
    int getStrange();
    int getAgility();
}

package UnitInterfaces;

public interface Experienceable extends Levelable {

    int getCurrentExp();
    int getRequiredExp();
    void takeExp(int howMuchExp);
}

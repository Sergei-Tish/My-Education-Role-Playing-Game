package UnitInterfaces;

public interface Experienceable {

    int currentExp();
    default int takeExp(int howMuchExp) {
        return currentExp() + howMuchExp;
    }
}

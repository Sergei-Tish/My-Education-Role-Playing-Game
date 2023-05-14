package UnitInterfaces;

public interface Levelable {
    int getLevel();
    void lvlUp();

    default void lvlUp(int numberOfLevel) {
        for (int i = 0; i < numberOfLevel; i++) {
            lvlUp();
        }
    }
}

public interface GoldInterface  {
    int gold = 0;
    default int getGold(){
        return gold;
    }
    int setGold(int setGold);
    default void dropGold() {
        if (this instanceof Playerable) {
            // выполняем действия для игрока
            setGold( getGold() / 10 * 9 );
            System.out.println("Игрок потерял 10% золота.");
        } else {
            // ничего не делаем
            System.out.println("Этот класс не наследуется от интерфейса Playerable");
        }
    }
}

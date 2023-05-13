package UnitInterfaces;

public interface GoldInterface  {
    int getGold();
    void minusGold(int howMuchMinus);
    void plusGold(int howMuchPlus);


//    default void dropGold() {
//        if (this instanceof UnitInterfaces.Playerable &&
//                ((UnitInterfaces.Playerable) this).playerCharacter()) {
//            // выполняем действия для игрока
//            lessGold(getGold() / 10);
//            System.out.println("Игрок потерял 10% золота.");
//        }  // ничего не делаем
//    }
}

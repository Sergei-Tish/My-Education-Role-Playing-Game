package WorldPackage;

import PlayerClases.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        System.out.println("ВОИН.toString() выводит: " + warrior);
        int a = warrior.getGold();
        warrior.minusGold(1);
    }
}

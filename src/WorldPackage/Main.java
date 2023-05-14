package WorldPackage;

import MainClassesAndOther.PlayerUnit;
import PlayerClases.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        System.out.println("ВОИН.toString() выводит: " + warrior);
        warrior.lvlUp(5);
        System.out.println("ВОИН.toString() выводит: " + warrior);
    }
}

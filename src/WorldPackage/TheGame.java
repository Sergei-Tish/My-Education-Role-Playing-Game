package WorldPackage;

import PlayerClases.Warrior;

import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) {

        System.out.println("Hello! It's the little game for you. \nPlease choose your hero's class.");
        System.out.println("Enter \"1\" to select Warrior. \nEnter \"2\" to choose Rogue");
        Scanner sc = new Scanner(System.in);
        int selectedClass = 0;
        do {
            String forScan = sc.nextLine();
            if (forScan.equals("1")) {
                selectedClass = 1;
                break;
            }
            else if (forScan.equals("2")) {
                selectedClass = 2;
                break;
            }
            else System.out.println("Please choose your hero's class. Enter \"1\" to select Warrior, or enter \"2\" to choose Rogue");
        } while (selectedClass != 1 || selectedClass != 2);

        String heroClass = "";
        int heroStrength = 0, heroAgility = 0;
        if (selectedClass == 1) {
            heroClass = "Warroir";
            heroStrength = 12;
            heroAgility = 10;
        }
        System.out.printf("Your %s have %d strength and %d agility. You have six more characteristic points. \nHow much will you invest in strength? Enter: \n", heroClass, heroStrength, heroAgility);









//        Warrior warrior = new Warrior("Boguno", 4, 2);
//        System.out.println("ВОИН.toString() выводит: " + warrior);
//        warrior.lvlUp(5);
//        System.out.println("ВОИН.toString() выводит: " + warrior);
    }
}
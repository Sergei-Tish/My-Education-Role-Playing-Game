package WorldPackage;

import MainClassesAndOther.PlayerUnit;
import PlayerClases.Warrior;

import java.util.Scanner;

public class HeroCreated {
    public static PlayerUnit create() {

        System.out.println("Hello! It's the little game for you. \nPlease choose your hero's class.");
        System.out.println("Enter \"1\" to select Warrior. \nEnter \"2\" to choose Rogue");
        Scanner sc = new Scanner(System.in);
        int selectedClass = 0;
        String heroClass = "";
        int heroStrength = 0;
        int heroAgility = 0;
        String heroName = "";
//        selectedClass
        do {
            String forScan = sc.nextLine();
            switch (forScan) {
                case "1", "Warrior" -> selectedClass = 1;
                case "2", "Rogue" -> selectedClass = 2;
                default ->
                        System.out.println("Please choose your hero's class. Enter \"1\" to select Warrior, or enter \"2\" to choose Rogue");
            }
        } while (selectedClass != 1 && selectedClass != 2);

//        heroClass; heroStrength; heroAgility
        switch (selectedClass) {
            case 1 -> {
                heroClass = "Warrior";
                heroStrength = 12;
                heroAgility = 10;
            }
            case 2 -> {
                heroClass = "Rogue";
                heroStrength = 10;
                heroAgility = 12;
            }
            default -> {
                heroClass = "AnotherClass";
                heroStrength = 8;
                heroAgility = 8;
            }
        }

        System.out.printf("Your %s have %d strength and %d agility. You have 6 more characteristic points. \n" +
                "How many points to increase the strength? Enter from 0 to 6: \n", heroClass, heroStrength, heroAgility);
//      bonus strength and agility
        String forScan;
        do {
            forScan = sc.nextLine();
            if (Integer.parseInt(forScan) >= 0 && Integer.parseInt(forScan) <= 6) {
                heroStrength += Integer.parseInt(forScan);
                heroAgility += 6 - Integer.parseInt(forScan);
                break;
            } else System.out.println("Enter from 0 to 6: ");
        } while (Integer.parseInt(forScan) < 0 || Integer.parseInt(forScan) > 6);
        System.out.printf("Your %s have %d strength and %d agility. \n", heroClass, heroStrength, heroAgility);
        //Name
        System.out.println("What your character's name?" + "\nEnter a name from 2-16 symbol: ");
        do {
            forScan = sc.nextLine();
            heroName = forScan;
            if (forScan.length() < 2 || forScan.length() > 16) {
                System.out.println("Uncorrected name. Please enter from 2-16 symbol: ");
            }
        } while (forScan.length() < 2 || forScan.length() > 16);
        PlayerUnit createdPlayerHero = switch (selectedClass) {
            case 1 -> new Warrior(heroName, heroStrength, heroAgility);
            case 2 -> new Warrior(heroName, heroStrength, heroAgility); // изменить  на Rogue
            default -> null;

        };
        return createdPlayerHero;






//        Warrior warrior = new Warrior("Boguno", 4, 2);
//        System.out.println("ВОИН.toString() выводит: " + warrior);
//        warrior.lvlUp(5);
//        System.out.println("ВОИН.toString() выводит: " + warrior);
    }
}
package MainClassesAndOther;

public abstract class MonsterUnit extends FighterUnit {

    String name = "Monster";
    String className = "MonsterUnit";
    private int strength = 8;
    private int agility = 8;
//    private int intelligence = 8;
//    private int wisdom = 8;
    private int maxHP;
    private int currentHP = getMaxHP();
    private int level = 1;
    private int awardXP;
    private int awardGold;
}

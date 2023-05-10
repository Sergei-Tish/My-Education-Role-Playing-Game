
public class Warrior implements GoldInterface {

    @Override
    public int getGold() {
        return GoldInterface.super.getGold();
    }

    @Override
    public int setGold(int setGold) {
        return 0;
    }

    @Override
    public void dropGold() {
        GoldInterface.super.dropGold();
    }
}




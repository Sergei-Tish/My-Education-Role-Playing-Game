public interface Tradeable extends GoldInterface {
    int gold = 0;
    default void payGold(int pay) {
        setGold(getGold() - pay);
    }
}

package gamePkg;

public interface IBackPack {
    void showItems();
    void putItem(Object item);
    Object getItem(int index);
    void dropItem(int index);
}

package gamePkg.gameItems;

public class ScrollOfMagic extends gamePkg.abstractions.ScrollOfMagic {
    int param;
    String name;

    public ScrollOfMagic(String name, int param) {
        this.name = name;
        this.param = param;
    }

    @Override
    public int readTheScroll() {
        return param;
    }

    @Override
    public int getParam() {
        return this.param;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

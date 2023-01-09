package gamePkg.gameItems;

import gamePkg.IPortal;

public class Portal implements IPortal {

    public boolean active;

    @Override
    public void quitGame() {
        System.out.println("Вы вошли портал будучи живым.");
        System.out.println("Игра окончена.");
        this.active = false;
        System.exit(1);
    }
}

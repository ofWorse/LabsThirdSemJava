package gamePkg.impl;

import gamePkg.IBackPack;
import gamePkg.menu.MenuUtils;

import java.util.ArrayList;
import java.util.List;

public class BackPackImpl implements IBackPack {

    public List<Object> backpack;

    public BackPackImpl() {
        this.backpack = new ArrayList<>(10);
    }

    @Override
    public void showItems() {
        if(this.backpack.isEmpty())
            System.out.println("\n[ рюкзак пуст ]");
        else {
            System.out.println("\n[ рюкзак ]");
            for(int i = 0; i < this.backpack.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + MenuUtils.getObjectName(this.backpack.get(i)));
            }
            System.out.println();
        }
    }

    @Override
    public void putItem(Object item) {
        if(this.backpack.size() == 10)
            System.out.println("\n[ рюкзак полон ]");
        else if(this.backpack.contains(item))
            System.out.println("\n[ у вас уже есть этот предмет в рюкзаке ]");
        else {
            this.backpack.add(item);
            System.out.println("\n[ Был положен предмет " + item.getClass().getCanonicalName() + " ]");
        }
    }

    @Override
    public Object getItem(int index) {
        return this.backpack.get(index);
    }

    @Override
    public void dropItem(int index) {
        this.backpack.remove(index);
    }

}

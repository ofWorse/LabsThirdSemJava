package tasks.task10;

import java.util.Random;

public class Writer extends Thread {

    private final int number;

    private final String[] strings = {"Карл у Клары", "У Лукоморья дуб срубили", "Ели мясо мужики",
    "Ехал Грека через реку", "Владимирский централ", "Кольщик", "Учат в школе",
    "Танец злобного гения"};

    public Writer(int num) {
        number = num;
    }

    @Override
    public void run() {
        int gotReader = 0;
        while (true) {
            for(int i = 0; i < Database.readers.size(); i++)
                if (Database.readers.get(i).reading())
                    gotReader++;

            if(gotReader == 0) {
                var randomBehaviour = new Random().nextBoolean();
                if (randomBehaviour) {
                    System.out.println("Писатель " + number + " что-то записал.");
                    writeData();
                } else if (!Database.data.isEmpty()) {
                    System.out.println("Писатель " + number + " что-то удалил.");
                    removeData();
                }
            }
            else interrupt();
        }
    }

    private void removeData() {
        Database.writerCount++;
        Database.data.poll();
        try {
            Database.writerCount--;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeData() {
        var rand = new Random().nextInt(strings.length);
        Database.writerCount++;
        Database.data.add(strings[rand]);
        try {
            Database.writerCount--;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

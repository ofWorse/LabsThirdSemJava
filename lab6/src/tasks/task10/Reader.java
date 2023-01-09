package tasks.task10;

public class Reader extends Thread {

    private int number;
    private static boolean isReading;

    public Reader(int num) {
        number = num;
        isReading = false;
    }

    @Override
    public void run() {
        while (true) {
            if(Database.writerCount == 0) {
                isReading = true;
                System.out.println("Читатель " + number + " прочел: " + Database.data);
                isReading = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                isReading = false;
                interrupt();
            }
        }
    }

    public boolean reading() {
        return isReading;
    }
}

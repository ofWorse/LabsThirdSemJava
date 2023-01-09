package tasks.task2;

public class ThreadForTask extends Thread {

    private final int number;

    public ThreadForTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long sec = 0;
        long start, end;

        while (true) {
            start = System.currentTimeMillis();

            System.out.println("Поток №" + this.number + " работает " + sec + " секунд.");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            end = System.currentTimeMillis();
            sec += (end - start) / 1000;
        }
    }
}

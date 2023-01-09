package tasks.task8;

import java.util.ArrayList;
import java.util.List;

public class PiCalculator {

    private List<ThreadForPi> threads;
    public static PiNumber piNumber;

    public PiCalculator() {
        threads = new ArrayList<>();
        piNumber = new PiNumber();
    }

    public void startCalculating() throws InterruptedException {
        runThreads();
    }

    private void runThreads() throws InterruptedException {
        System.out.println("Ждите...");
        for(int i = 1; i <= 5; i++)
            threads.add(new ThreadForPi(i));
        for(var thread : threads) {
            thread.start();
            Thread.sleep(200);
        }
    }

}

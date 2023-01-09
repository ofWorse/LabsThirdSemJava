package tasks.task9;

import java.util.Random;

public class EatingPhilosophersProblem {

    private final static Random RANDOM = new Random();

    static class PhilosopherEating extends Thread {

        int forkOne;
        int forkTwo;

        public PhilosopherEating(String name, int forkOne, int forkTwo) {
            super(name);
            this.forkOne = forkOne;
            this.forkTwo = forkTwo;
        }

        @Override
        public void run() {

            while (true) {
                requireLock(this, forkOne, forkTwo);
                try {
                    Thread.sleep(RANDOM.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Boolean[] forks = new Boolean[]{Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
            Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE};

    private static void requireLock(PhilosopherEating philosopherEating, int firstIndex, int secondIndex) {

        if (firstIndex > secondIndex) {
            int temp = firstIndex;
            firstIndex = secondIndex;
            secondIndex = temp;
        }

        if (firstIndex == 7 || secondIndex == 7) {
            System.err.println(firstIndex + " и " + secondIndex);
        }

        synchronized (forks[firstIndex]) {
            synchronized (forks[secondIndex]) {

                printPhilosopherAction(philosopherEating, "ест.");

                try {
                    Thread.sleep(RANDOM.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                printPhilosopherAction(philosopherEating, "думает.");

            }
        }
    }

    private static void printPhilosopherAction(PhilosopherEating philosopherEating, String action) {
        System.out.println("Философ " + philosopherEating.getName() + " " + action);
    }
}
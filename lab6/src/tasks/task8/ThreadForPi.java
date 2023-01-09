package tasks.task8;

public class ThreadForPi extends Thread {

    private int i;
    public ThreadForPi(int i) {
         this.i = i;
    }

    @Override
    public void run() {
        long start, end, sum;
        start = System.currentTimeMillis();
        while (PiCalculator.piNumber.getPI() != 3.1415926535) {
            try {
                calculate();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        end = System.currentTimeMillis();
        sum = end - start;
        System.out.println(String.format("Готово. PI = %.10f", PiNumber.PI));
        System.out.println("Общее время в секундах: " + sum/1000);
    }

    private void calculate() throws InterruptedException {
        synchronized (PiCalculator.piNumber) {
            PiCalculator.piNumber.setPI();
            PiCalculator.piNumber.setA();
            PiCalculator.piNumber.setPositive();
        }
    }
}

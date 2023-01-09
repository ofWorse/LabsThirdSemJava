package tasks.task6;

import java.util.concurrent.locks.ReentrantLock;

public class Producer extends Thread {

    private boolean interrupted;
    private int numberOfProducer;
    private ReentrantLock reentrantLock;

    public Producer(int num) {
        this.interrupted = false;
        this.numberOfProducer = num;
        this.reentrantLock = new ReentrantLock();
    }

    public boolean isInterrupted() {
        return this.interrupted;
    }


    @Override
    public void run() {
        int limit = 0;
        int elem;
        boolean ans = reentrantLock.tryLock();

        if(ans) {
            while (limit <= 100 && Chat.buffer.size() <= Chat.MAX_BUFFER_SIZE) {
                reentrantLock.lock();
                try {
                    elem = (int) Math.round(Math.random() * 100);
                    Chat.buffer.add(elem);
                    System.out.println("Производитель № " + this.numberOfProducer + " создал элемент: " + elem);
                    limit++;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        else {
            System.out.println("Производитель № " + this.numberOfProducer + " ждет своей очереди.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        interrupt();
        this.interrupted = true;
        System.out.println("Производитель № " + this.numberOfProducer + " устал.");
    }
}

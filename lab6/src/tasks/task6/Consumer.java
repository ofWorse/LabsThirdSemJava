package tasks.task6;

import java.util.concurrent.locks.ReentrantLock;

public class Consumer extends Thread {

    private Producer producer;
    private int numberOfConsumer;
    private ReentrantLock reentrantLock;

    public Consumer(Producer producer, int num) {
        this.producer = producer;
        this.numberOfConsumer = num;
        this.reentrantLock = new ReentrantLock();
    }

    @Override
    public void run() {

        boolean ans = reentrantLock.tryLock();

        if(ans) {
            while (!producer.isInterrupted()) {
                reentrantLock.lock();
                try {
                    if (Chat.buffer.isEmpty()) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("Потребитель № " + this.numberOfConsumer + " взял элемент: " + Chat.buffer.peek());
                        Chat.buffer.poll();
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        else {
            System.out.println("Потребитель № " + this.numberOfConsumer + " ждет своей очереди.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        interrupt();
        System.out.println("Потребитель № " + this.numberOfConsumer + " устал.");
    }
}

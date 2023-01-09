package tasks.task5;

public class Consumer extends Thread {

    private Producer producer;
    private int numberOfConsumer;

    public Consumer(Producer producer, int num) {
        this.producer = producer;
        this.numberOfConsumer = num;
    }

    @Override
    public void run() {
        while (!producer.isInterrupted()) {
            if (Chat.buffer.isEmpty()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Потребитель № " + this.numberOfConsumer + " взял элемент.");
                Chat.buffer.poll();
            }
        }
        interrupt();
        System.out.println("Потребитель № " + this.numberOfConsumer + " устал.");
    }
}

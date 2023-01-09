package tasks.task7;

public class Consumer extends Thread {

    private Producer producer;
    private int numberOfConsumer;

    public Consumer(Producer producer, int num) {
        this.producer = producer;
        this.numberOfConsumer = num;
    }

    @Override
    public void run() {

        getItem();

        interrupt();
        System.out.println("Потребитель № " + this.numberOfConsumer + " устал.");
    }

    private synchronized void getItem() {
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
    }
}

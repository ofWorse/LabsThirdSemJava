package tasks.task7;

public class Producer extends Thread {

    private boolean interrupted;
    private int numberOfProducer;

    public Producer(int num) {
        this.interrupted = false;
        this.numberOfProducer = num;
    }

    public boolean isInterrupted() {
        return this.interrupted;
    }

    @Override
    public void run() {
        int limit = 0;

        createItem(limit);

        interrupt();
        this.interrupted = true;
        System.out.println("Производитель № " + this.numberOfProducer + " устал.");
    }

    private synchronized void createItem(int limit) {
        while (limit <= 100 && Chat.buffer.size() <= Chat.MAX_BUFFER_SIZE) {
            int elem = (int) Math.round(Math.random() * 100);
            Chat.buffer.add(elem);
            System.out.println("Производитель № " + this.numberOfProducer + " создал элемент: " + elem);
            limit++;
        }
    }
}

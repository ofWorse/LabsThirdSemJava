package tasks.task5;

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

    // Отсутствие паузы перед отправкой данных в очередь влечет за собой ее моментальное переполнение.
    @Override
    public void run() {
        int limit = 0;
        int elem;

        while (limit <= 1000000 && Chat.buffer.size() <= Chat.MAX_BUFFER_SIZE) {
            elem = (int) Math.round(Math.random() * 100);
            Chat.buffer.add(elem);
            System.out.println("Производитель № " + this.numberOfProducer + " создал элемент: " + elem);
            limit++;
        }

        interrupt();
        this.interrupted = true;
        System.out.println("Производитель № " + this.numberOfProducer + " устал.");
    }
}

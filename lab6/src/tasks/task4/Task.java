package tasks.task4;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        ThreadRunner threads = new ThreadRunner(10);
        threads.runThreads();
    }
}

package tasks.task1;

public class Task {
    public static void main(String[] args) throws InterruptedException {

        new ThreadRunner(10).runThreads();

        Thread.sleep(1000);
        System.out.println("Главный поток завершен.");
    }
}

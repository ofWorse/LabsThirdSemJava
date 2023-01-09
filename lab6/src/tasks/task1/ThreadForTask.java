package tasks.task1;

public class ThreadForTask extends Thread {

    private final int number;

    public ThreadForTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Hello from thread №" + this.number);
    }
}

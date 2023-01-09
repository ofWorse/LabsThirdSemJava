package tasks.task3;

import java.util.ArrayList;
import java.util.List;

public class ThreadRunner {

    List<ThreadForTask> threads;
    private int countOfThreads;

    public ThreadRunner(int countOfThreads) {
        this.countOfThreads = countOfThreads;
        this.threads = new ArrayList<>();
    }

    public void runThreads()  {
        for(int i = 1; i <= this.countOfThreads; i++) {
            threads.add(new ThreadForTask(i));
        }
        threads.forEach(Thread::start);
    }
}

package tasks.task1;

import java.util.ArrayList;
import java.util.List;

public class ThreadRunner {

    private int countOfThreads;

    public ThreadRunner(int countOfThreads) {
        this.countOfThreads = countOfThreads;
    }

    public void runThreads() {
        List<ThreadForTask> threads = new ArrayList<>();
        for(int i = 1; i <= this.countOfThreads; i++) {
            threads.add(new ThreadForTask(i));
        }
        threads.forEach(Thread::start);
    }
}

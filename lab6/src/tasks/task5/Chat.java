package tasks.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Chat {
    public static int MAX_BUFFER_SIZE = 100000;
    private static List<Consumer> consumers;
    private static List<Producer> producers;
    public static Queue<Integer> buffer;


    public Chat() {
        producers = new ArrayList<>();
        consumers = new ArrayList<>();
        buffer = new ArrayBlockingQueue<>(MAX_BUFFER_SIZE);
    }

    public void startChatting() {
        for(int i = 1; i <= 10; i++) {
            producers.add(new Producer(i));
            consumers.add(new Consumer(producers.get(i-1), i));
        }
        producers.forEach(Thread::start);
        consumers.forEach(Thread::start);
    }


}

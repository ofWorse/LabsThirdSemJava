package tasks.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Database {

    public static Queue<String> data;
    public static List<Reader> readers;
    public static List<Writer> writers;
    private int MAX_SIZE = 1000;

    public static int writerCount;

    public Database() {
        data = new ArrayBlockingQueue<>(MAX_SIZE);
        this.readers = new ArrayList<>();
        writers = new ArrayList<>();
        writerCount = 0;
    }

    public void startProcess() {
        for(int i = 1; i <= 5; i++)
            writers.add(new Writer(i));
        for(int i = 1; i <= 10; i++)
            readers.add(new Reader(i));

        writers.forEach(Thread::start);
        readers.forEach(Thread::start);
    }
}

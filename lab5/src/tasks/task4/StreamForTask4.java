package tasks.task4;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

public class StreamForTask4 {
    private final String leninSrcPath;

    public StreamForTask4(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task() throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        AtomicLong count = new AtomicLong();
        words.stream().forEach(word -> count.addAndGet(word.length()));

        System.out.println("Готово.");
        System.out.println("Всего использовано символов в словах: " + count);
    }
}

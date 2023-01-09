package tasks.task3;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamForTask3 {
    private final String leninSrcPath;

    public StreamForTask3(String[] args) {
        this.leninSrcPath = args[0];
    }


    public void task(String path) throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedList = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        WordListCollector.writeResultToFile(path, sortedList);
        System.out.println("Готово.");
    }

}

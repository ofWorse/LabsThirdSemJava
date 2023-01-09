package tasks.task5;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamForTask5 {
    private final String leninSrcPath;

    public StreamForTask5(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task1(String path) throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var map = words.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        WordListCollector.writeResultToFile(path, map);
        System.out.println("Готово.5.1");
    }

    public void task2(String path) throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedMap = words.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

        WordListCollector.writeResultToFile(path, sortedMap);
        System.out.println("Готово.5.2");
    }


    public void task3(String path) throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedMap = words.stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(Function.identity()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        WordListCollector.writeResultToFile(path, sortedMap);

        System.out.println("Готово.5.3");
    }

}

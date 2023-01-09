package tasks.task2;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamForTask2 {
    private final String leninSrcPath;

    public StreamForTask2(String[] args) {
        this.leninSrcPath = args[0];
    }


    public void task1(String path) throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedList = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .toList();

        var res = sortedList.stream()
                        .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()));

        WordListCollector.writeResultToFile(path, res);
        System.out.println("Готово.2.1");
    }

    public void task2(String path) throws IOException {

        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedList = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        WordListCollector.writeResultToFile(path, sortedList);
        System.out.println("Готово.2.2");
    }

    public void task3(String path) throws IOException {

        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Predicate<String> pr = s -> s.length() <= 7 && s.length() >= 4;

        var sortedMap = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .filter(pr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        WordListCollector.writeResultToFile(path, sortedMap);
        System.out.println("Готово.2.3");
    }

    public void task4(String path) throws IOException {

        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Predicate<String> pr = s -> s.length() <= 7 && s.length() >= 4;

        var sortedMap = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .filter(pr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var set = new TreeMap<>(sortedMap);

        WordListCollector.writeResultToFile(path, set);
        System.out.println("Готово.2.4");
    }
}

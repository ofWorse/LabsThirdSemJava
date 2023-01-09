package tasks.task1;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class StreamForTask1 {
    private final String leninSrcPath;

    public StreamForTask1(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task1(String path) throws IOException {
        var uniqueWords = WordListCollector.getAllWordsFromFile(this.leninSrcPath);
        var set = new HashSet<>(uniqueWords);
        WordListCollector.writeResultToFile(path, set);
        System.out.println("Готово.1.1");
    }

    public void task2(String path) throws IOException {
        var uniqueWords = WordListCollector.getAllWordsFromFile(this.leninSrcPath);
        var treeSet = new TreeSet<>(uniqueWords);

        var res = treeSet.stream()
                .sorted(Comparator.comparing(String::length)
                .reversed())
                .toList();

        WordListCollector.writeResultToFile(path, res);
        System.out.println("Готово.1.2");
    }

    public void task3(String path) throws IOException {
        var uniqueWords = WordListCollector.getAllWordsFromFile(this.leninSrcPath);
        var treeSet = new TreeSet<>(uniqueWords);

        Predicate<String> pr = s -> s.length() <= 7 && s.length() >= 4;

        var res = treeSet.stream()
                .sorted(Comparator.comparing(String::length)
                .reversed())
                .filter(pr)
                .toList();


        WordListCollector.writeResultToFile(path, res);
        System.out.println("Готово.1.3");
    }
}

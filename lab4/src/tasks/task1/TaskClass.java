package tasks.task1;

import tasks.CWordListCollector;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class TaskClass {

    private String leninSrcPath;

    public TaskClass(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task1(String path) throws IOException {
        var setOfWords = (TreeSet<String>) CWordListCollector.getSetOfWordsFromFile(this.leninSrcPath);

        CWordListCollector.writeResultToFile(path, setOfWords);
        System.out.println("Готово.1");
    }

    public void task2(String path) throws IOException {

        var setOfWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        List<String> newList = new ArrayList<>(setOfWords);
        newList.sort(Comparator.comparing(String::length) // сортировка по длине
                .reversed() // перевернуть
                .thenComparing(Function.identity())); // сравнить естественным путем

        CWordListCollector.writeResultToFile(path, newList);
        setOfWords.clear();
        System.out.println("Готово.2");
    }

    public void task3(String path) throws IOException {

        var setOfWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        List<String> newList = new ArrayList<>(setOfWords);
        newList.sort(Comparator.comparing(String::length)
                .reversed()
                .thenComparing(Function.identity()));

        newList.removeIf(element -> element.length() < 4 || element.length() > 7);

        CWordListCollector.writeResultToFile(path, newList);
        System.out.println("Готово.3");
    }
}

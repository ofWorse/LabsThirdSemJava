package tasks.task2;

import tasks.CWordListCollector;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class taskClass {

    private String leninSrcPath;

    public taskClass(String[] args) {
        leninSrcPath = args[0];
    }


    public void task1(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        long sum = 0;
        long start, end;

        try (var fw = new FileWriter(path)) {
            int count = 1;
            for(int i = 1; i < listOfAllWords.size(); i++) {
                start = System.currentTimeMillis();
                if(listOfAllWords.get(i).equals(listOfAllWords.get(i-1))) count++;
                else {
                    fw.write(listOfAllWords.get(i-1) + " -> " + count + " использований.\n");
                    count = 1;
                }
                end = System.currentTimeMillis();
                sum += end - start;
            }
        }

        listOfAllWords.clear();
        System.out.println("Общее время работы со списком: " + sum + "мс.");
        System.out.println("Готово2.1.");
    }

    public void task2(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var map = new HashMap<String, Integer>();

        long sum = 0;
        long start, end;

        for(var word : listOfAllWords) {
            start = System.currentTimeMillis();
            Integer count;
            if((count = map.get(word)) != null)
                map.put(word, count+1);
            else map.put(word, 1);
            end = System.currentTimeMillis();
            sum += end - start;
        }

        CWordListCollector.writeResultToFile(path, map);
        listOfAllWords.clear();
        System.out.println("Общее время работы с отображением: " + sum+"мс.");
        System.out.println("Готово2.2.");
    }

    public void task3(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var map = new HashMap<String, Integer>();

        for(var word : listOfAllWords) {
            Integer count;
            if((count = map.get(word)) != null)
                map.put(word, count+1);
            else map.put(word, 1);
        }

        Predicate<String> pr = word -> (word.length() > 7 || word.length() < 4);

        map.keySet().removeIf(pr);

        CWordListCollector.writeResultToFile(path, map);
        listOfAllWords.clear();
        System.out.println("Готово2.3.");
    }

    public void task4(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var map = new HashMap<String, Integer>();
        var sortedResultList = new ArrayList<String>();

        for(var word : listOfAllWords) {
            Integer count;
            if((count = map.get(word)) != null)
                map.put(word, count+1);
            else map.put(word, 1);
        }

        Predicate<String> pr = word -> (word.length() > 7 || word.length() < 4);

        map.keySet().removeIf(pr);

        for(var element : map.keySet())
            sortedResultList.add(element + " -> " + map.get(element) + " использований.\n");

          sortedResultList
                .sort(Comparator
                .comparing(String::length)
                .reversed()
                .thenComparing(Function.identity()));

        CWordListCollector.writeResultToFile(path, sortedResultList);
        listOfAllWords.clear();
        System.out.println("Готово2.4.");
    }

}

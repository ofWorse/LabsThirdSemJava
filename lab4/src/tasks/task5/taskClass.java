package tasks.task5;

import tasks.CWordListCollector;

import java.io.IOException;
import java.util.*;


public class taskClass {

    private String leninSrcPath;


    public taskClass(String[] args) {
        this.leninSrcPath = args[0];
    }


    public void task1(String path) throws IOException {
        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var resMap = new HashMap<Character, Integer>();

        int count;
        for(var word : listOfAllWords) {
            for(int i = 0; i < word.length(); i++) {
                if(resMap.containsKey(word.charAt(i))) {
                    count = resMap.get(word.charAt(i)) + 1;
                    resMap.put(word.charAt(i), count);
                }
                else resMap.put(word.charAt(i), 1);
            }
        }
        CWordListCollector.writeResultToFile(path, resMap);
        resMap.clear();
        listOfAllWords.clear();
        System.out.println("Готово.5.1");
    }

    public void task2(String path) throws IOException {
        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var resMap = new TreeMap<Character, Integer>();

        int count;
        for(var word : listOfAllWords) {
            for(int i = 0; i < word.length(); i++) {
                if(resMap.containsKey(word.charAt(i))) {
                    count = resMap.get(word.charAt(i)) + 1;
                    resMap.put(word.charAt(i), count);
                }
                else resMap.put(word.charAt(i), 1);
            }
        }
        CWordListCollector.writeResultToFile(path, resMap);
        resMap.clear();
        listOfAllWords.clear();
        System.out.println("Готово.5.2");
    }

    public void task3(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        Collections.sort(listOfAllWords);

        var resMap = new HashMap<Character, Integer>();

        int count;
        for(var word : listOfAllWords) {
            for(int i = 0; i < word.length(); i++) {
                if(resMap.containsKey(word.charAt(i))) {
                    count = resMap.get(word.charAt(i)) + 1;
                    resMap.put(word.charAt(i), count);
                }
                else resMap.put(word.charAt(i), 1);
            }
        }
        var list = new ArrayList<>(resMap.entrySet()); // список пар
        list.sort(Comparator.comparingInt(
                (Map.Entry<Character, Integer> e) -> e.getValue())
                .reversed());

        CWordListCollector.writeResultToFile(path, list);

        resMap.clear();
        System.out.println("Готово.5.3");
    }

}

package tasks.task3;

import tasks.CWordListCollector;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

public class taskClass {
    private String leninSrcPath;

    public taskClass(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task(String path) throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        listOfAllWords.sort(Comparator.comparing(String::length));

        var resMap = new HashMap<Integer, Integer>();
        int count = 1;
        for(int i = 1; i < listOfAllWords.size(); i++) {
            if(listOfAllWords.get(i-1).length() ==
            listOfAllWords.get(i).length()) count++;
            else {
                resMap.put(listOfAllWords.get(i-1).length(), count);
                count = 1;
            }
        }

        CWordListCollector.writeResultToFile(path, resMap);
        System.out.println("Готово.");
    }
}

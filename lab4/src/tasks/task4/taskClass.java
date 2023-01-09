package tasks.task4;

import tasks.CWordListCollector;

import java.io.IOException;
import java.util.Collections;

public class taskClass {

    private String leninSrcPath;
    private static CWordListCollector wordListCollector;

    public taskClass(String[] args) {
        this.leninSrcPath = args[0];
        wordListCollector = new CWordListCollector();
    }

    public void task() throws IOException {
        var listOfAllWords = wordListCollector.getAllWordsFromFile(this.leninSrcPath);
        Collections.sort(listOfAllWords);

        int count = 0;
        for (var listOfAllWord : listOfAllWords)
            count += listOfAllWord.length();

        System.out.println("Готово.4");
        System.out.println("Всего использовано символов во всех словах: " + count);
    }
}

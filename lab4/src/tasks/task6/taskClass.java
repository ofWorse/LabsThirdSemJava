package tasks.task6;

import tasks.CWordListCollector;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class taskClass {

    private String leninSrcPath;

    public taskClass(String[] args) {
        this.leninSrcPath = args[0];
    }

    public void task() throws IOException {

        var listOfAllWords = CWordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var wordAndCount = new HashMap<String, Integer>();

        // отображение: длина слова и использования
        for(var word : listOfAllWords) {
            Integer count;
            if((count = wordAndCount.get(word)) != null)
                wordAndCount.put(word, count + 1);
            else
                wordAndCount.put(word, 1);
        }

        countingByLength(wordAndCount, 15);

        System.out.println("Готово.");
    }

    private void countingByLength(Map<String, Integer> wordAndCount, int i) throws IOException {
        create(wordAndCount).forEach((length, set) -> {
            System.out.println("\nДлина : " + length);
            set.stream().limit(i).forEach(System.out::println);
        });
    }

    private Map<Integer, TreeSet<Word>> create(Map<String, Integer> wordAndCount) {
        var resMap = new HashMap<Integer, TreeSet<Word>>();

        for(var word : wordAndCount.keySet()) {
            if(resMap.containsKey(word.length()))
                resMap.get(word.length()).add(new Word(word, wordAndCount.get(word)));
            else {
                var set = new TreeSet<Word>();
                set.add(new Word(word, wordAndCount.get(word)));
                resMap.put(word.length(), set);
            }
        }
        return resMap;
    }

    private static class Word implements Comparable<Word> {

        private final String name;
        private final Integer number;

        public Word(String name, Integer number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public int compareTo(Word word) {
            int comparableNumber = word.number.compareTo(this.number);
            return comparableNumber == 0 ? this.name.compareTo(word.name) : comparableNumber;
        }

        @Override
        public String toString() {
            return this.name + " (" + number + " раз.) ";
        }
    }
}

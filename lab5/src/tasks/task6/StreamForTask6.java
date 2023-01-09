package tasks.task6;

import tasks.WordListCollector;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamForTask6 {
    private final String leninSrcPath;

    public StreamForTask6(String[] args) {
        this.leninSrcPath = args[0];
    }


    public void task() throws IOException {
        var words = WordListCollector.getAllWordsFromFile(this.leninSrcPath);

        var sortedList = words.stream()
                .sorted(Comparator
                .comparing(String::length)
                .thenComparing(Function.identity()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countingByLength(sortedList, 15);

        System.out.println("Готово.");
    }

    private void countingByLength(Map<String, Long> sortedList, int i) {
        create(sortedList).forEach((length, set) -> {
            System.out.println("\nДлина : " + length);
            set.stream().limit(i).forEach(System.out::println);
        });
    }
    private Map<Integer, TreeSet<Word>> create(Map<String, Long> wordAndCount) {
        var resMap = new HashMap<Integer, TreeSet<Word>>();

        for(var word : wordAndCount.keySet()) {
            if(resMap.containsKey(word.length()))
                resMap.get(word.length()).add(new Word(word, Math.toIntExact(wordAndCount.get(word))));
            else {
                var set = new TreeSet<Word>();
                set.add(new Word(word, Math.toIntExact(wordAndCount.get(word))));
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


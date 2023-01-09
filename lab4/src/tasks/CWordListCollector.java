package tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CWordListCollector {

    public static List<String> getAllWordsFromFile(String leninSrcPath) throws IOException {
        var bufferedReader = new CToReadFileClass().readLeninFile(leninSrcPath);
        String line;
        var listOfAllWords = new ArrayList<String>();

        while((line = bufferedReader.readLine()) != null)
            readLineFromFile(line, listOfAllWords);

        return listOfAllWords;
    }

    public static Iterable<String> getSetOfWordsFromFile(String leninSrcPath) throws IOException {
        var bufferedReader = new CToReadFileClass().readLeninFile(leninSrcPath);
        String line;
        var listOfAllWords = new TreeSet<String>();

        while((line = bufferedReader.readLine()) != null)
            readLineFromFile(line, listOfAllWords);

        return listOfAllWords;
    }


    private static void readLineFromFile(String line, Collection<String> setOfWords) {
        var words = line.toLowerCase().split("[\\p{Punct}\\d\\s«…»–]+");

        for(var word : words)
            if(!word.isEmpty())
                setOfWords.add(word);
    }
    
    public static void writeResultToFile(String filename, Map<?, ?> letterAndCount) throws IOException {
        try(var fw = new FileWriter(filename)) {
            for (var element : letterAndCount.keySet())
                fw.write(element + " -> " + letterAndCount.get(element) + " раз.\n");
        }
    }

    public static void writeResultToFile(String filename, Collection<?> lines) throws IOException {
        try (var writer = new FileWriter(filename)) {
            for (var e : lines)
                writer.write(e + " \n");
        }
    }
}

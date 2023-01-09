package tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordListCollector {

    public static List<String> getAllWordsFromFile(String leninSrcPath) throws IOException {

        var splitter = Pattern.compile("[\\p{Punct}\\d\\s«…»–]+");

        return Files.lines(Path.of(leninSrcPath))
                .flatMap(splitter::splitAsStream)
                .filter(w -> !w.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public static Iterable<String> getSetOfWordsFromFile(String leninSrcPath) throws IOException {

        var splitter = Pattern.compile("[\\p{Punct}\\d\\s«…»–]+");

        return Files.lines(Path.of(leninSrcPath))
                .flatMap(splitter::splitAsStream)
                .filter(w -> !w.isEmpty())
                .collect(Collectors.toSet());
    }


    // TODO переделать под стримы
    public static void writeResultToFile(String filename, Map<?, ?> letterAndCount) throws IOException {
        try(var fw = new FileWriter(filename)) {
            for (var element : letterAndCount.keySet())
                fw.write(element + " -> " + letterAndCount.get(element) + " раз.\n");
        }
    }

    public static void writeResultToFile(String filename, Collection<?> lines) throws IOException {
        Files.write(Path.of(filename), (Iterable<? extends CharSequence>) lines);
    }

    public static void writeResultToFile(String filename, List<String> lines) throws IOException {
        Files.write(Path.of(filename), lines);
    }
}

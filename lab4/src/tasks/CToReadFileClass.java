package tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CToReadFileClass {
    public BufferedReader readLeninFile(String path) throws FileNotFoundException {
        var reader = new FileReader(path);
        return new BufferedReader(reader);
    }
}

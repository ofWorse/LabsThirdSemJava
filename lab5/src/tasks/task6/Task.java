package tasks.task6;

import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        if(args.length != 1)
            throw new RuntimeException("ВВЕДИТЕ: <путь к исходнику>");
        new StreamForTask6(args).task();
    }
}

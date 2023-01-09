package tasks.task4;

import java.io.IOException;

public class Task {
    public static void main(String[] args) throws IOException {
        if(args.length != 1)
            throw new RuntimeException("ВВЕДИТЕ: <путь к исходнику>");
        new StreamForTask4(args).task();
    }
}

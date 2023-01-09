package tasks.task6;

import java.io.IOException;

public class Ctask {
    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            throw new RuntimeException("ВВЕДИТЕ: <путь к исходнику>\n");
        new taskClass(args).task();
    }
}

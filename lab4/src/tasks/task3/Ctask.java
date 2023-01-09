package tasks.task3;

import java.io.IOException;

public class Ctask {
    public static void main(String[] args) throws IOException {
        if(args.length != 2)
            throw new RuntimeException("ВВЕДИТЕ: <путь к исходнику> <путь к файлу для записи результатов>" +
                    "\nЕсли файла для записи результатов не существует, то программа создаст его сама.");
        new taskClass(args).task(args[1]);
    }
}

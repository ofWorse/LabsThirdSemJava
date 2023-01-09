package task2;

import java.util.Scanner;

public class toDaysHoursMinSec {

    public static int[] fromSecsToDHMS(int seconds) {
        int m, h, d;
        m = (seconds % 3600) / 60;
        h = seconds / 60 / 60;
        d = seconds / (3600*24);

        int []result = {m, h, d};

        System.out.println(seconds%60+" sec, " + m + " min, " + h + " hour, " + d + " days");

        return result;
    }
    
    public static void main(String[] args) {
        int s;

        System.out.println("Введите количество секунд: ");
		try (Scanner scan = new Scanner(System.in)) {
			s = scan.nextInt();
		}

        fromSecsToDHMS(s);
        System.out.println("Программа завершена.");
    }
}
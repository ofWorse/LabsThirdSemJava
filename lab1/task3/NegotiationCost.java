package task3;

import java.util.Scanner;

public class NegotiationCost {
    public static void main(String[] args) {
        int startTime, duration, cost, daysOfTheWeek;
        int countOfMin = 0;
        double result;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Введите час с начала звонка: ");
            startTime = scan.nextInt();
            System.out.println("Введите продолжительность звонка в минутах: ");
            duration = scan.nextInt();
            System.out.println("Введите стоимость звонка за минуту: ");
            cost = scan.nextInt();
            System.out.println("Введите день недели: ");
            daysOfTheWeek = scan.nextInt();
        }

        result = Concatinate(startTime, duration, cost, daysOfTheWeek, countOfMin);
        System.out.println("Стоимость звонка составляет: " + result);
        System.out.println("Программа завершена");
    }

    public static double Concatinate(int startTime, int duration, int cost, int daysOfTheWeek, int countOfMin) {
        double res = 0;

        while (duration != 0) {
            countOfMin++;
            duration--;
            if (countOfMin == 60) {
                startTime++;
                countOfMin = 0;
            }
            if (startTime == 24) {
                daysOfTheWeek++;
                startTime = 0;
            }
            if (daysOfTheWeek == 8) {
                daysOfTheWeek = 1;
            }

            if ((daysOfTheWeek > 5 && daysOfTheWeek < 8) &&
                    (startTime >= 22 || startTime <= 8))
                res += cost - cost * 0.3;
            else if ((daysOfTheWeek < 6) && (startTime >= 22 || startTime <= 8))
                res += cost - cost * 0.2;
            else if ((startTime < 22 || startTime > 8) &&
                    (daysOfTheWeek > 5 && daysOfTheWeek < 8))
                res += cost - cost * 0.1;
            else res += cost;
        }

        return res;
    }
}
package gamePkg.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AuxiliaryMethods {

    public static int inputProtection(int min, int max) {

        Scanner scan = new Scanner(System.in);
        int userChoice;

        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                if (scan.hasNextInt()) {
                    userChoice = scan.nextInt();
                    if (userChoice < min || userChoice > max)
                        System.out.println("\nВведите число от \'" + min + "\' до \'" + max + "\' !!!\n");
                    else {
                        System.out.println("Вы выбрали -> " + userChoice);
                        break;
                    }
                } else {
                    System.out.println("\nВведите число!\n");
                    return System.err.hashCode();
                }
            } catch (InputMismatchException e) {
                return System.err.hashCode();
            }
        }
        return userChoice;
    }
}

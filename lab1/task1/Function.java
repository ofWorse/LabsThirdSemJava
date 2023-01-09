package task1;

import java.util.Scanner;
import static java.lang.Math.*;

public class Function {
    public static void main(String[] args) {
        double x, y, result;
        
        System.out.println("Введите два числа x и y: ");
        
        try (Scanner scan = new Scanner(System.in)) {
			x = scan.nextDouble();
			y = scan.nextDouble();
		}

        result = Func(x, y);

        System.out.println("результат: " + result);
        System.out.println("Программа завершена");
    }
    
	public static double Func(double x, double y) {
        double F;
        F = (sqrt((pow(2 + y, 2) + pow(abs(sin(y + 5)), 1.7)))) /
        		(log(x + 1) - pow(y, 3));
        return F;
	}
}

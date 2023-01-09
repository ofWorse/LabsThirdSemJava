package task5;

import java.util.Scanner;

public class SumOfTheRow {
	public static void main(String[] args) {
		double x, n;
		double S = 0;
		System.out.println("Введите значения для переменных x и n:");
		try (Scanner scan = new Scanner(System.in)) {
			x = scan.nextInt();
			n = scan.nextInt();
		}
		
		S = FuncSum(x, n);
		System.out.println("Результат вычислений: " + S);
		System.out.println("Программа завершена");
	}
	
	public static double FuncSum(double x, double n) {
		double res = 0;
		
		for(double k = 3; k <= n; k++) {
			if(k == 5)
				continue;
			else { 
				res += (Math.pow(-2, k-1))/((k-5) * Math.pow(x, k));
				res *= FuncMult(k);
			}
		}
		return res;
	}
	
	public static double FuncMult(double k) {
		double multiply = 1;
		for(double i = 1; i <= k+7; i++) {
			if(i == 7 || i == 3)
				continue;
			else
				multiply *= (Math.pow(i, 3) - 27)/(i - 7); 
		}
		return multiply;
	}
	
}

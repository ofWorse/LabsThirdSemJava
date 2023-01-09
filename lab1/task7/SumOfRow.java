package task7;

import java.util.Scanner;

public class SumOfRow {
	public static void main(String[] args) {
		double x, result = 0;  
		int N;
		System.out.println("Введите x: ");
		try (Scanner scan = new Scanner(System.in)) {
			x = scan.nextDouble();
			System.out.println("Введите число вхождений: ");
			N = scan.nextInt();
		}
		
		double number = 3, power = 2, div = 1;
		result = Func(x, number, power, div, N);
		
		System.out.println("Результат вычислений: " + result);
		System.out.println("Программа завершена");
	}
	public static double Func(double x, double number, double power, double div, int N) {
		double res = 0;
		
		for(int i = 1; i <= N; i++) {
			res += (number*(Math.pow(x, power)))/(Fact(div));
			number += 2;
			power += 2;
			div++;
		}
		res++;
		
		return res;
	}
	private static int Fact(double num) {
		int  i = 1;
		while(i <= num) {
			i *= i;
			i++;
		}
		return i;
	}
}

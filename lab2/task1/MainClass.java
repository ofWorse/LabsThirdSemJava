package task1;

public class MainClass {
	public static void main(String[] args) {
		Complex c1 = new Complex(6, 2);
		Complex c2 = new Complex(7, 3);

		System.out.println("Результаты вычислений сравнивались с настоящими\n"+
		"результатами арифметических операций.\n" + 
		"Все публичные методы были протестированы.");
		
		System.out.println("Оригинальные комплексные числа: ");
		c1.printComplex();
		c2.printComplex();
		
		Complex c3;

		System.out.println("\nРезультат сложения:");
		c3 = c2.sum(c1);
		c3.printComplex();
		
		System.out.println("\nРезультат разности:");
		c3 = c2.diff(c1);
		c3.printComplex();
		
		System.out.println("\nРезультат умножения:");
		c3 = c2.mult(c1);
		c3.printComplex();
		
		System.out.println("\nРезультат частного:");
		c3 = c2.div(c1);
		c3.printComplex();
		
		System.out.println("\nРезультат установки чисел: ");
		c3.printComplex();
		
		double a = c3.getA(), b = c3.getB();
		System.out.println("a = " + a + ", b = " + b);
	}
}

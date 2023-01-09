package task1;

public class Complex {
	private double a;
	private double b;

	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public Complex() {
		this.a = 0.0;
		this.b = 0.0;
	}
	
	public Complex sum(Complex addition) {
		return new Complex(a + addition.a, b + addition.b);
	}
	
	public Complex diff(Complex difference) {
		return new Complex(a - difference.a, b - difference.b);
	}
	
	public Complex mult(Complex multiplication) {
		return new Complex(a * multiplication.a - b * multiplication.b, a * multiplication.b + b * multiplication.a);
	}
	
	public Complex div(Complex divive) {
		var a = ((this.a * divive.a) + (this.b * divive.b)) / (Math.pow(divive.a, 2) + Math.pow(divive.b, 2));
		var b = ((divive.a * this.b) - (this.a * divive.b)) / (Math.pow(divive.a, 2) + Math.pow(divive.b, 2));
		return new Complex(a, b);
	}
	
	public void printComplex() {
		System.out.printf("Z = %.1f + %.1fi\n", this.a, this.b);
	}

	public double getA() { return a; }
	public double getB() { return b; }

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}
}
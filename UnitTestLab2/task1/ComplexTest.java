package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ComplexTest {

	double a, b;
	Complex c, c1, c2;
	
	@BeforeEach
	public void CreateComplex() { 
		c = new Complex();
		c2 = new Complex(6, 2);
		c1 = new Complex(7, 3);
		c1.sum(c2).div(c1).sum(c2);
	}
	
	@Test
	public void GettersSettersTest() {
		a = c.getA();
		b = c.getB();
		assertEquals(a, 0.0);
		assertEquals(a, b);
		
		c.setA(101);
		c.setB(100);
		
		a = c.getA();
		b = c.getB();
		
		assertNotEquals(a, b);
		assertEquals(a, 101);
		assertEquals(b, 100);
		
		System.out.println("Тест на получение и установку членов был пройден успешно!");
	}
	
	@Test
	public void ArithmeticTest() {
		c = c1.sum(c2);
		a = 13;
		b = 5;
		assertEquals(c.getA(), a);
		assertEquals(c.getB(), b);
		
		c = c1.diff(c2);
		a = 1;
		b = 1;
		assertEquals(c.getA(), a);
		assertEquals(c.getB(), b);
		
		c = c1.mult(c2);
		a = 36;
		b = 32;
		assertEquals(c.getA(), a);
		assertEquals(c.getB(), b);
		
		c = c1.div(c2);
		a = 1.2;
		b = 0.1;
		assertEquals(c.getA(), a);
		assertEquals(c.getB(), b);
		
		System.out.println("Тест на арифметические операции был пройден успешно!");
	}
}

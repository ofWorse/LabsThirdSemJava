package task6;

public class Palindrome {
	public static void main(String[] args) {
		
		for(long i = 1; i < 1_000_000_000; i++) {
			long num = 0, k = i*i;
			for(long j = k; j > 0; j /= 10) 
				num = num*10 + (j%10);
			if(k==num)
				System.out.println(i+" "+num);
		}
		
		System.out.println("Программа завершена.");
		
	}
}

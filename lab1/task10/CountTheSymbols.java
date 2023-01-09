package task10;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class CountTheSymbols {
	public static void main(String[] args) {
		String str;
		System.out.println("Введите строку для подсчета каждого символа в ней: ");
		try (Scanner scan = new Scanner(System.in)) {
			str = scan.nextLine();
		}
		
		CountSymbols(str);
	}
	public static void CountSymbols(String str) {
		Map<String, Integer> values = new HashMap<>();
		for(int i = 0; i < str.length(); i++ ) {
			String temp = (str.substring(i, i+1));
			values.computeIfPresent(temp, (k, v) -> v+1);
			values.putIfAbsent(temp, 1);
		}
		for(Entry<String, Integer> entry : values.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("Буква: " + key + " появляется " + value + " раз(a).");
		}
	}
}

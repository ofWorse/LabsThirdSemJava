package task11;

import java.util.Scanner;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println("Введите строку для нахождения палиндрома в подстроке:");
		try (Scanner scan = new Scanner(System.in)) {
			String string = scan.nextLine();
			
			System.out.println("Самый длинный палиндром в строке: " + longestPalindromeString(string));
		}
		System.out.println("Программа завершена.");
	}

	static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	public static String longestPalindromeString(String s) {
		if (s == null) return null;
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; i++) {
			String palindrome = intermediatePalindrome(s, i, i);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome.length() > longest.length()) {
				longest = palindrome;
			}
		}
		return longest;
	}

}
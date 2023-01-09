package task11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest extends LongestPalindrome {

    @Test
    void WholeStringIsPalindromeTest() {
        String palindrome = "ab3l__l3ba";
        String actual = "ab3l__l3ba";

        if(actual == longestPalindromeString(palindrome)) {
            System.out.println("Тест был пройден!");
        }
        else System.out.println("Тест не был пройден!");
    }

    @Test
    void IfStringIsNullTest() {
        String palindrome = null;
        String actual = null;

        if(actual == longestPalindromeString(palindrome)) {
            System.out.println("Тест был пройден!");
        }
        else System.out.println("Тест не был пройден!");
    }

    @Test
    void randomStringTest() {
        String palindrome = "qweabcbartydefggfeduio";
        String actual = "defggfed";

        if(actual == longestPalindromeString(palindrome))
            System.out.println("Тест был пройден!");
        else System.out.println("Тест не был пройден!");
    }

}
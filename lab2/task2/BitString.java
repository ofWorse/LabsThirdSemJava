package task2;

import java.util.Scanner;

public class BitString {

    private String string;
    private long low;
    private long high;

    public BitString() {
        enterString();
        string = stringToBinary();
        toLong();
    }

    private BitString(long low, long high) {
        this.low = low;
        this.high = high;
    }

    public BitString and(BitString bs) {
        return new BitString(low & bs.low, high & bs.high);
    }

    public BitString or(BitString bs) {
        return new BitString(low | bs.low, high | bs.high);
    }

    public BitString xor(BitString bs) {
        return new BitString(low ^ bs.low, high ^ bs.high);
    }

    public void not() {
        String s = string;
        s = s.replaceAll("0", "x");
        s = s.replaceAll("1", "0");
        s = s.replaceAll("x", "1");

        string = s;
        toLong();
    }

    public void dropBit(int index) {
        StringBuilder s = new StringBuilder(string);
        if(s.charAt(index) == '1') s.setCharAt(index, '0');

        string = String.valueOf(s);
        toLong();
    }

    public void setBit(int index) {
        StringBuilder s = new StringBuilder(string);
        if(s.charAt(index) == '0') s.setCharAt(index, '1');

        string = String.valueOf(s);
        toLong();
    }

    public void shiftLeft(long index) {
        low = low * (long)Math.pow(2, index);
        high = high * (long)Math.pow(2, index);
    }

    public void shiftRight(long index) {
        low = low / (long)Math.pow(2, index);
        high = high / (long)Math.pow(2, index);
    }

    private void enterString() {
        String s;
        do {
            System.out.print("Введите строку длинной в 16 символов (128 бит): ");
            s = new Scanner(System.in).nextLine();
        } while (s.length() != 16);
        string = s;
    }

   private String stringToBinary() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            res.append(Long.toBinaryString(c));
        }
        return res.toString();
    }

    private void toLong() {
        low = Long.parseUnsignedLong(string, 0, 7,  2);
        high = Long.parseUnsignedLong(string, 8, 17, 2);
    }

    public void printString() {
        System.out.println(Long.toBinaryString(low) + Long.toBinaryString(high));
    }

    public String getString() {
        return string;
    }
}

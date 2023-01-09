package task2;

public class Main {
    public static void main(String... args) {

        // helloWorldMyName itsTimeToShowYou

        BitString bs1 = new BitString();
        BitString bs2 = new BitString();

        System.out.println("И");
        bs1.printString();
        bs2.printString();
        var res = bs1.and(bs2);
        res.printString();
        System.out.println();

        System.out.println("ИЛИ");
        bs1.printString();
        bs2.printString();
        res = bs1.or(bs2);
        res.printString();
        System.out.println();

        System.out.println("XOR");
        bs1.printString();
        bs2.printString();
        res = bs1.xor(bs2);
        res.printString();
        System.out.println();

        System.out.println("НЕ");
        bs1.printString();
        bs1.not();
        bs1.printString();
        System.out.println();

        bs1.not();

        System.out.println("СБРОС БИТА");
        bs1.printString();
        bs1.dropBit(1);
        bs1.printString();
        System.out.println();

        System.out.println("УСТАНОВКА БИТА");
        bs1.printString();
        bs1.setBit(4);
        bs1.printString();
        System.out.println();

        System.out.println("Побитовый сдвиг вправо на 5: ");
        bs1.printString();
        bs1.shiftRight(5);
        bs1.printString();

        bs1.shiftLeft(5);

        System.out.println("Побитовый сдвиг вправо на 5: ");
        bs1.printString();
        bs1.shiftLeft(5);
        bs1.printString();
    }
}

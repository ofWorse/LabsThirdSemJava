package tasks.task8;

public class PiNumber {
    public static double PI;
    public static double a;
    public static boolean positive;

    public PiNumber() {
        PI = 0.0d;
        a = 1.0d;
        positive = true;
    }

    public double getPI() {
        return PI;
    }

    public double getA() {
        return a;
    }

    public boolean getPositive() {
        return positive;
    }

    public void setA() {
        a += 2;
    }

    public void setPositive() {
        positive = !positive;
    }

    public void setPI() {
        PI += sum();
    }

    private double sum() {
        return positive ? 4/a : -4/a;
    }
}

package ch.hslu.SW02.Aufgabe_1;

public class ggT {

    public static void main(String[] args) {
        System.out.println(ggT(31, 15));
    }

    public static int ggT(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }
}

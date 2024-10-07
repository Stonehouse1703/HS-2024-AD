package ch.hslu.SW02.Aufgabe_4;

public class Fibo {

    private static int[] memo;

    public static void main(String[] args) {
        System.out.println(fiboRec1(4));
        System.out.println(fiboRec2(10));
        System.out.println(fiboIter(10));
    }

    private static int fiboRec1(int n) {
        if (n <= 1) {
            return n;
        }
        return fiboRec1(n - 1) + fiboRec1(n - 2);
    }

    public static int fiboRec2(int n) {
        // Fehlerbehandlung für ungültige Eingaben
        if (n < 0) {
            throw new IllegalArgumentException("Der Index darf nicht negativ sein: " + n);
        }

        // Initialisierung des Memo-Arrays
        memo = new int[n + 1];

        // -1 default
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        // Setze die Basisfälle
        memo[0] = 0;
        if (n > 0) {
            memo[1] = 1;
        }

        // Aufruf des Hilfsverfahrens
        return fiboRec2Calculation(n);
    }

    private static int fiboRec2Calculation(int n) {
        // Überprüfen, ob der Wert bereits berechnet wurde
        if (memo[n] != -1) {
            return memo[n];
        }

        // Berechne den Wert rekursiv und speichere ihn im Memo-Array
        memo[n] = fiboRec2Calculation(n - 1) + fiboRec2Calculation(n - 2);
        return memo[n];
    }



    public static int fiboIter(int n) {
        if (n <= 1) { //damit nicht 1 oder 0
            return n;
        }
        int fib = 1, prev = 0;
        for (int i = 2; i <= n; i++) {
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        return fib;
    }

}

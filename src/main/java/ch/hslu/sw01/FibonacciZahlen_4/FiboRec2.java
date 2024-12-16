package ch.hslu.sw01.FibonacciZahlen_4;

public class FiboRec2 {

    // Array zur Speicherung der Zwischenresultate
    private static int[] memo;

    public static int fiboRec2(int n) {
        // Basisfälle
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        // Überprüfung, ob das Ergebnis schon berechnet wurde
        if (memo[n] != -1) {
            return memo[n];
        }

        // Rekursive Berechnung und Speichern des Ergebnisses
        memo[n] = fiboRec2(n - 1) + fiboRec2(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10; // Beispiel: F(10) berechnen
        memo = new int[n + 1]; // Array erstellen mit Platz für n+1 Elemente
        // Array initialisieren mit -1 (Signal, dass das Ergebnis noch nicht berechnet wurde)
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        // F(10) berechnen und ausgeben
        System.out.println("F(" + n + ") = " + fiboRec2(n));
    }
}

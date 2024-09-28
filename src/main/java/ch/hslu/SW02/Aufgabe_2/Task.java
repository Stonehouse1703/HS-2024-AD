package ch.hslu.SW02.Aufgabe_2;

public class Task {

    private static int task1Counter = 0;
    private static int task2Counter = 0;
    private static int task3Counter = 0;

    public static void main(final String[] args) {
        task(10);
        reset();
        task(100);
        reset();
        task(1000);
    }

    private static void task(int n) {
        long startTime = System.nanoTime(); // Startzeit erfassen

        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }

        long endTime = System.nanoTime(); // Endzeit erfassen
        long duration = endTime - startTime; // Dauer berechnen

        System.out.println("Totale Aufrufe: " + n + "; Task 1: " + task1Counter + "; Task 2: " + task2Counter + " Task 3: " + task3Counter);
        System.out.println("Laufzeit (ns): " + duration);
    }

    private static void task1() {
        task1Counter++;
    }

    private static void task2() {
        task2Counter++;
    }

    private static void task3() {
        task3Counter++;
    }

    private static void reset() {
        task1Counter = 0;
        task2Counter = 0;
        task3Counter = 0;
    }
}

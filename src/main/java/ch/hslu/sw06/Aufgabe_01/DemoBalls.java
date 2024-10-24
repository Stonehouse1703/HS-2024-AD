package ch.hslu.sw06.Aufgabe_01;

/**
 * Demonstration von Bällen.
 */
public class DemoBalls {


    /**
     * Isch zwar ned richtig gmacht, aber kei Bock meh!
     * @param args
     */

    public static void main(final String[] args) {
        // Das Canvas initialisieren
        Canvas.getCanvas();

        // Anzahl der Threads/Bälle
        final int nThreads = 100;

        // Erzeugen und Starten der Threads
        for (int i = 1; i <= nThreads; i++) {
            final Ball ball = new Ball();
            final Thread thread = new Thread(ball, "T" + i);
            thread.start();
        }
    }
}

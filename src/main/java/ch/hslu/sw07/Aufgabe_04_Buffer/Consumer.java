/*
 * Copyright 2024 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw07.Aufgabe_04_Buffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeoutException;

/**
 * Konsument, der so viele Werte aus einer Queue liest, wie er nur kann.
 */
public final class Consumer implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);
    private final BoundedBuffer<Integer> queue; // Die Warteschlange, aus der die Integer-Werte gelesen werden.
    private long sum; // Summe der ausgelesenen Werte.

    /**
     * Erzeugt einen Konsumenten, der soviel Integer-Werte ausliest, wie er nur kann.
     *
     * @param queue Queue zum Lesen der Integer-Werte.
     */
    public Consumer(final BoundedBuffer<Integer> queue) {
        this.queue = queue; // Initialisiert die Warteschlange für den Konsumenten.
        this.sum = 0; // Setzt die Summe initial auf 0.
    }

    @Override
    public void run() {
        // Endlosschleife, um kontinuierlich Werte aus der Warteschlange zu konsumieren.
        while (true) {
            try {
                // Versucht, ein Element aus der Warteschlange zu entfernen, mit einem Timeout von 10 Millisekunden.
                Integer temp = queue.remove(10);
                // Wenn kein Element innerhalb des Timeouts entfernt werden kann, wird temp null.
                if (temp == null) {
                    LOG.info("Consumer get timeout"); // Protokolliert, wenn der Timeout erreicht wird.
                    break; // Beendet die Schleife.
                }
                // Summiert den ausgelesenen Wert.
                sum += temp;
            } catch (InterruptedException ex) {
                // Beendet die Ausführung, wenn der Thread unterbrochen wird.
                return;
            } catch (TimeoutException ex) {
                // Bei Timeout-Exzeption wird die Schleife ebenfalls beendet.
                return;
            }
        }
    }

    /**
     * Liefert die Summe aller ausgelesener Werte.
     *
     * @return Summe.
     */
    public long getSum() {
        return sum; // Gibt die Summe der konsumierten Werte zurück.
    }
}

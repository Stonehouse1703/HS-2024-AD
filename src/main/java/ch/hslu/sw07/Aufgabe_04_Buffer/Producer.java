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

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Produzent, der eine maximale Anzahl Werte produziert und diese in eine Queue speichert.
 */
public final class Producer implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class); // Logger für das Protokollieren von Ereignissen
    private final BoundedBuffer<Integer> queue; // Die Warteschlange, in die die Integer-Werte geschrieben werden.
    private final int maxRange; // Die maximale Anzahl an Werten, die produziert werden sollen.
    private long sum; // Summe der produzierten Werte.

    /**
     * Erzeugt einen Produzent, der eine bestimmte Anzahl Integer-Werte produziert.
     *
     * @param queue Queue zum Speichern der Integer-Werte.
     * @param max Anzahl Integer-Werte.
     */
    public Producer(final BoundedBuffer<Integer> queue, final int max) {
        this.queue = queue; // Initialisiert die Warteschlange für den Produzenten.
        this.maxRange = max; // Setzt die maximale Anzahl an zu produzierenden Werten.
        this.sum = 0; // Setzt die Summe initial auf 0.
    }

    @Override
    public void run() {
        // Schleife, um die maximal definierte Anzahl an Werten zu produzieren.
        for (int i = 0; i < maxRange; i++) {
            try {
                // Versucht, den aktuellen Wert in die Warteschlange hinzuzufügen, mit einem Timeout von 10 Millisekunden.
                if (!queue.add(i, 10)) {
                    LOG.info("Producer put timeout"); // Protokolliert, wenn der Timeout erreicht wird.
                    break; // Beendet die Schleife, wenn der Timeout erreicht wurde.
                }
                // Summiert den produzierten Wert.
                sum += i;
            } catch (InterruptedException ex) {
                // Beendet die Ausführung, wenn der Thread unterbrochen wird.
                return;
            }
        }
    }

    /**
     * Liefert die Summe aller gespeicherter Werte.
     *
     * @return Summe.
     */
    public long getSum() {
        return sum; // Gibt die Summe der produzierten Werte zurück.
    }
}

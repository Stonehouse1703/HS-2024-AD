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

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Puffer nach dem First in First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elemente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    // Die interne Warteschlange zur Speicherung der Elemente des Puffers.
    private final ArrayDeque<T> queue;
    // Semaphore, um die Anzahl der produzierbaren Elemente im Puffer zu steuern.
    private final Semaphore putSema;
    // Semaphore, um die Anzahl der konsumierbaren Elemente aus dem Puffer zu steuern.
    private final Semaphore takeSema;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n); // Initialisiert die Warteschlange mit der angegebenen Kapazität.
        putSema = new Semaphore(n);    // Erlaubt bis zu n Elemente im Puffer (Produzenten).
        takeSema = new Semaphore(0);    // Erlaubt anfangs keine Entnahmen (Konsumenten).
    }

    @Override
    public void add(final T elem) throws InterruptedException {
        putSema.acquire(); // Wartet, bis ein Platz im Puffer verfügbar ist.
        synchronized (queue) {
            queue.addFirst(elem); // Fügt das Element am Anfang der Warteschlange hinzu.
        }
        takeSema.release(); // Erhöht die Anzahl der konsumierbaren Elemente.
    }

    @Override
    public T remove() throws InterruptedException {
        takeSema.acquire(); // Wartet, bis ein Element im Puffer vorhanden ist.
        T elem;
        synchronized (queue) {
            elem = queue.removeLast(); // Entfernt das letzte Element der Warteschlange.
        }
        putSema.release(); // Erhöht die Anzahl der produzierbaren Elemente.
        return elem; // Gibt das entfernte Element zurück.
    }

    @Override
    public boolean add(T elem, long millis) throws InterruptedException {
        if (putSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            synchronized (queue) {
                queue.addFirst(elem);
            }
            takeSema.release();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T remove(long millis) throws InterruptedException, TimeoutException {
        if (takeSema.tryAcquire(millis, TimeUnit.MILLISECONDS)) {
            T elem;
            synchronized (queue) {
                elem = queue.removeLast();
            }
            putSema.release();
            return elem;
        } else {
            throw new TimeoutException("Unable to remove element, the request timed out.");
        }
    }

    @Override
    public boolean empty() {
        return this.takeSema.availablePermits() < 1; // Es gibt keine konsumierbaren Elemente.
    }

    @Override
    public boolean full() {
        return !this.empty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }
}

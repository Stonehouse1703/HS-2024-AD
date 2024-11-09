/*
 * Copyright 2024 Hochschule Luzern Informatik.
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
package ch.hslu.sw08.Aufgabe_01_Primzahlen;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 100 grosse Primzahlen finden.
 */
public final class PrimeCheck {

    private static final Logger LOG = LoggerFactory.getLogger(PrimeCheck.class);
    private static final List<Future<BigInteger>> futures = new ArrayList<>();

    /**
     * Privater Konstruktor.
     */
    private PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int countTreads = Runtime.getRuntime().availableProcessors() + 1;
        int primeCount = 100;
        int counter = 1;

        long startTime = System.currentTimeMillis();
        try(ExecutorService executorService = Executors.newFixedThreadPool(countTreads)){
            while (counter <= primeCount){
                futures.add(executorService.submit(new Berechner()));
                counter++;
            }

            counter = 1;
            for (Future<BigInteger> future : futures) {
                System.out.println(counter + " = " + future.get().toString().substring(0, 20));
                counter++;
            }

            long endtime = System.currentTimeMillis();
            LOG.info("{} Berechnungen wurden durchgeführt " +
                    " - in {} Sekunden " +
                    " - mit {} Threads"
                    , primeCount, (endtime- startTime)/1000, countTreads);

        } catch (ExecutionException | InterruptedException e){
            LOG.error(e.getMessage());
        }


    }
}

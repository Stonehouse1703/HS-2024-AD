package ch.hslu.sw08.Aufgabe_01_Primzahlen;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class Berechner implements Callable<BigInteger> {

    @Override
    public BigInteger call() {
        while(true){
            BigInteger bi = new BigInteger(1024, new Random());
            if (bi.isProbablePrime(100)) {
                return bi;
            }
        }
    }
}

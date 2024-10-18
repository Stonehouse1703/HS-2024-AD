package ch.hslu.SW05.Aufgabe_3;

import java.util.Objects;

public class Zahl {
    private int wert;

    public Zahl(int zahl){
        this.wert = zahl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Zahl zahl)
                && wert == zahl.wert
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(wert);
    }

    @Override
    public String toString() {
        return Integer.toString(wert);
    }
}

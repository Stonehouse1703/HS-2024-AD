package ch.hslu.SW05;

import java.util.Objects;

public class Number {

    private int wert;

    public Number (int number){
        this.wert = number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Number number)
                && wert == number.wert
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(wert);
    }
}

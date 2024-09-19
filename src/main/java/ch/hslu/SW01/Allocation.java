package ch.hslu.SW01;

import java.util.Objects;

public final class Allocation implements Comparable {

    //---------------< Konstruktor >---------------
    private final int size;
    private final int adress;

    //---------------< Konstruktor >---------------
    public Allocation(final int adress, final int size) {
        if (adress < 0 || size < 0) {
            throw new IllegalArgumentException("Adress and size must be greater than 0");
        }
        this.adress = adress;
        this.size = size;
    }

    //---------------< Getter >---------------
    public int getAdress() {
        return this.adress;
    }

    public int getSize() {
        return this.size;
    }

    //---------------< Methoden >---------------
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Allocation that)
                && size == that.size
                && adress == that.adress
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, adress);
    }

    @Override
    public String toString() {
        return "Allocation [Adresse: " + this.adress + "; Size: " + this.size + "]";
    }
}

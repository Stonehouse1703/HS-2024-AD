package ch.hslu.SW01;

import java.util.Objects;

public final class Allocation implements Comparable {

    //---------------< Attribute >---------------
    private final int size;
    private final int adress;
    private int blockAdress;
    private int blockAdress2 = 0;

    //---------------< Konstruktor >---------------
    public Allocation(final int adress, final int size, final int blockAdress, final int blockAdress2) {
        if (adress < 0 || size < 0) {
            throw new IllegalArgumentException("Adress and size must be greater than 0");
        }
        this.adress = adress;
        this.size = size;
        this.blockAdress = blockAdress;
        this.blockAdress2 = blockAdress2;
    }

    public Allocation(final int adress, final int size, final int blockAdress) {
        this(adress, size, blockAdress, 0);
    }
    //---------------< Getter >---------------
    public int getAdress() {
        return this.adress;
    }

    public int getSize() {
        return this.size;
    }

    public int getBlockAdress(){
        if (blockAdress2 >= 0){
            return blockAdress+blockAdress2;
        }
        return blockAdress;
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
        return "Allocation [Adresse: " + this.adress + "; Size: " + this.size + "; BlockAdress: " + this.blockAdress + "; BlockAdress2: " + this.blockAdress2 + "]";
    }
}

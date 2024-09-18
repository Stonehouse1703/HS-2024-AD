package ch.hslu.SW01;

public final class Allocation implements Comparable {

    //---------------< Konstruktor >---------------
    private final int size;
    private final int adress;

    //---------------< Konstruktor >---------------
    public Allocation(final int adress, final int size) {
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
    public String toString() {
        return "Allocation [Adresse: " + this.adress + "; Size: " + this.size + "]";
    }
}

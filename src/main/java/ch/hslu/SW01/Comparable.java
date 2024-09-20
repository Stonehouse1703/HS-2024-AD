package ch.hslu.SW01;

public interface Comparable {

    /**
     * Gibt die Adresse der Allocation zurueck
     * @return Adesse
     */
    public int getAdress();

    /**
     * Gibt die Groesse der Allocation zurueck
     * @return Groesse
     */
    public int getSize();
    public boolean equals(final Object o);
    public int hashCode();
    public String toString();
}

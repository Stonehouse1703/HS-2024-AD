package ch.hslu.SW01;

public interface Memory {

    /**
     * Erstellt einen neuen Speicherblock und überprüft ob der Speicher Platz hat.
     * @param size
     * @return allocation
     */
    Allocation malloc(int size);

    /**
     * Gibt die freien Bytes zurueck
     * @return Verfügbarer Speicher
     */
    public int freeSize();

    /**
     * Löscht eine Allocation
     */
    public void free(Allocation allocation);
    public boolean equals(Object o);
    public int hashCode();
    public String toString();
    public int getSizeMap();
    public State getStatus(int auswahl);
}

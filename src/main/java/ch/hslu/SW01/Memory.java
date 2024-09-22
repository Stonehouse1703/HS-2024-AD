package ch.hslu.SW01;

public interface Memory {

    /**
     * Gibt die Anzahl der Bytes im Speicher zurück.
     * @return grösse des Speichers
     */
    public int getTotalSize();

    /**
     * Gibt die Anzahl der Bytes im Speicher verwendet.
     * @return belegter Speicher
     */
    public int getUsedSize();

    /**
     * Gibt die Anzahl der Bytes pro Cluster an.
     * @return Clustergrösse
     */
    public int getClusterSize();

    /**
     * Erstellt einen Datei im Speicher.
     * @param size (grösse des gewünschten Speichers)
     * @return Allocation mit Adresse und Größe
     * @throws IllegalArgumentException falls size <= 0
     * @throws IllegalArgumentException falls size > totalSize
     */
    public Allocation malloc(final int size);

    public String toString();

    /**
     * gibt den Speicher wieder frei
     * @param allocation
     */
    public void free(final Allocation allocation);

    /**
     * Gitb alle Cluster in einem String aus
     * @return Frei, Belegt
     */
    public String getAllocations();

    public boolean equals(final Object o);

    public int hashCode();
}

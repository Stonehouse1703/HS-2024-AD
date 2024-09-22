package ch.hslu.SW01;

import java.util.Arrays;

public interface Comparable {

    /**
     * gibt die Adresse des Speichers an, als String
     * @return SpeicherAdresse (String)
     */
    public String getAdressString();

    /**
     * gibt die Grösse des Speichers an, als String
     * @return SpeicherGröße (String)
     */
    public String getSizeString();

    public String toString();

    /**
     * gibt die Adresse des Speichers an, als Array
     * @return SpeicherAdresse (Array)
     */
    public int[] getAdress();

    /**
     * gibt die Grösse des Speichers an, als Array
     * @return SpeicherGröße (Array)
     */
    public int[] getSize();

    public boolean equals(final Object o);

    public int hashCode();
}

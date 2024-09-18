package ch.hslu.SW01;

import java.util.Objects;

// Aufgabe 2.3 b)
public final class Allokation implements Comparable{

    //---------------< Attribute >---------------
    private final int startAdresse;
    private final int speicherBlockGroesse;

    //---------------< Konstruktoren >---------------
    public Allokation(final int startAdresse, final int speicherBlockGroesse) {
        this.startAdresse = startAdresse;
        this.speicherBlockGroesse = speicherBlockGroesse;
    }

    //---------------< Getter >---------------
    public int getStartAdresse() {
        return this.startAdresse;
    }

    public int getSpeicherBlockGroesse() {
        return this.speicherBlockGroesse;
    }

    //---------------< Methoden >---------------
    public final int hashCode() {
        return Objects.hash(this.startAdresse, this.speicherBlockGroesse);
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Allokation p)
                && (p.startAdresse == this.startAdresse)
                && (p.speicherBlockGroesse == this.speicherBlockGroesse);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

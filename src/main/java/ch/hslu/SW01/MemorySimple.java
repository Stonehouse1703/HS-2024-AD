package ch.hslu.SW01;

import java.util.Objects;

public class MemorySimple implements Memory{

    //---------------< Methoden >---------------
    private final int totalSize;
    private int usedSize = 0;

    //---------------< Konstruktor >---------------
    public MemorySimple(int totalSize) {
        this.totalSize = totalSize;
    }

    //---------------< Methoden >---------------
    public Allocation malloc(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size, must be greater than 0");
        }
        if (usedSize + size > totalSize) {
            throw new IllegalArgumentException("Not enough memory available to allocate");
        }
        Allocation allocation = new Allocation(usedSize, size);
        usedSize += size;
        return allocation;
    }

    /**
     * Gibt die freien Bytes zurueck
     * @return
     */
    public int freeSize() {
        return totalSize - usedSize;
    }

    /**
     * Freigibt die angegebene Allokation
     * @param allocation
     */
    public void free(Allocation allocation) {
        usedSize -= allocation.getSize();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof MemorySimple that)
                && totalSize == that.totalSize
                && usedSize == that.usedSize
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalSize, usedSize);
    }

    @Override
    public String toString() {
        return "MemorySimple [Belegt: " + this.usedSize + "; Gesamt: " + freeSize() + "]";
    }
}

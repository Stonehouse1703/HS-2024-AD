package ch.hslu.SW01;

import java.util.*;

public class MemorySimple implements Memory{

    //---------------< Attribute >---------------
    private int totalSize;
    private int usedSize = 0;


    //---------------< Konstruktor >---------------
    public MemorySimple(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size, must be greater than 0");
        }
        this.totalSize += size;

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

    public int freeSize() {
        return totalSize - usedSize;
    }

    public void free(Allocation allocation) {
        totalSize -= allocation.getSize();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof MemorySimple that)
                && totalSize == that.totalSize
                && usedSize == that.usedSize
                ;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(totalSize, usedSize);
    }

    @Override
    public String toString() {
        return "MemorySimple [Belegt: " + this.usedSize + "; Gesamt: " + freeSize() + "]";
    }
}

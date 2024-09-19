package ch.hslu.SW01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemorySimple implements Memory {

    final Map<Integer, State> map = new HashMap<>();
    //---------------< Attribute >---------------
    private final int totalSize;
    private int usedSize = 0;
    private int blockSize = 512;
    private int blockCount;
    int firstSlot;
    int secondSlot;

    //---------------< Konstruktor >---------------
    public MemorySimple(int totalSize) {
        if (totalSize <= 0) {
            throw new IllegalArgumentException("Invalid size, must be greater than 0");
        }
        this.totalSize = totalSize;
        this.blockCount = totalSize / blockSize;

        for (int i = 1; i < blockCount; i++) {
            map.put(i, State.FREE);
        }
    }

    //---------------< Methoden >---------------
    public Allocation malloc(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size, must be greater than 0");
        }
        if (usedSize + size > totalSize) {
            throw new IllegalArgumentException("Not enough memory available to allocate");
        }
        if (size >= 512) {
            int count = 0;
            for (int i = 1; i < blockCount; i++) {
                if (map.get(i) == State.FREE) {
                    if (count == 0) {
                        firstSlot = i;
                        count++;
                    } else if (count == 1) {
                        secondSlot = i;
                        count++;
                    }
                }
            }
            if (count <= 1) {
                throw new IllegalArgumentException("Not enough memory available to allocate");
            } else {
                map.replace(firstSlot, State.ALLOCATED);
                map.replace(secondSlot, State.ALLOCATED);
                Allocation allocation = new Allocation(usedSize, size, firstSlot, secondSlot);
                usedSize += size;
                return allocation;
            }
        } else {
            for (int i = 1; i < blockCount; i++) {
                if (map.get(i) == State.FREE) {
                    map.replace(i, State.ALLOCATED);
                    Allocation allocation = new Allocation(usedSize, size, i);
                    usedSize += size;
                    return allocation;
                }
            }
        }
        return null;
    }

    public int freeSize() {
        return totalSize - usedSize;
    }

    public int getSizeMap(){
        return map.size();
    }

    /**
     * Freigibt die angegebene Allokation
     * @param allocation
     */
    public void free(Allocation allocation) {
        usedSize -= allocation.getSize();
        map.replace(allocation.getBlockAdress(), State.FREE);
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof MemorySimple that)
                && totalSize == that.totalSize
                && usedSize == that.usedSize;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(totalSize, usedSize);
    }

    @Override
    public String toString() {
        return "MemorySimple [Belegt: " + this.usedSize + "; Gesamt: " + freeSize() + "]";
    }

    public State getStatus(int auswahl){
        return map.get(auswahl);
    }
}

package ch.hslu.SW01;

public class MemorySimple implements Memory {

    //---------------< Methoden >---------------
    private final int totalSize;
    private int usedSize = 0;

    //---------------< Konstruktor >---------------
    public MemorySimple(int totalSize) {
        this.totalSize = totalSize;
    }

    public Allocation malloc(int size) {
        if (size <= 0 || usedSize + size > totalSize) {
            return null;
        }
        Allocation allocation = new Allocation(usedSize, size);
        usedSize += size;
        return allocation;
    }

    public int freeSize() {
        return totalSize - usedSize;
    }

    public void free(Allocation allocation) {
        usedSize -= allocation.getSize();
    }

    @Override
    public String toString() {
        return "MemorySimple [Belegt: " + this.usedSize + "; Gesamt: " + freeSize() + "]";
    }
}

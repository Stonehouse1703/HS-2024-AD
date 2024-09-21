package ch.hslu.SW01;

import java.util.HashMap;
import java.util.Map;

public class MemorySimple implements Memory{

    //------------------------< Attribute >-------------------------
    private int totalSize;
    private int usedSize;
    private int clusterSize;

    final Map<Integer, Status> map = new HashMap<>();

    //------------------------< Konstruktor >------------------------


    public MemorySimple(final int totalSize, final int clusterSize, int usedSize) {
        this.totalSize = totalSize;
        this.clusterSize = clusterSize;
        usedSize = this.usedSize;

        for (int i = 0; i < totalSize; i += clusterSize) {
            map.put(i, Status.FREE);
        }
    }

    public MemorySimple(final int totalSize, final int clusterSize) {
        this(totalSize, clusterSize, 0);
    }

    public MemorySimple(Memory memory) {
        this(memory.getTotalSize(), memory.getClusterSize(), memory.getUsedSize());
    }

    public Allocation malloc(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        if (usedSize + size > totalSize) {
            throw new IllegalArgumentException("No more memory left");
        }

        int countClusters = size / clusterSize;
        // falls size nicht durch clusterSize teilbar ist, muss 1 hinzugezählt werden
        if (size % clusterSize != 0) {
            countClusters++;
        }

        int countAdress[] = new int[countClusters];
        int countSize[] = new int[countClusters];
        int s = 0;
        int a = 0;

        while (size >= clusterSize){
            countSize[s] = clusterSize;
            s++;
            size -= clusterSize;
        }
        countSize[s] = size;

        for (int i = 0; i < totalSize; i += clusterSize) {
            if (map.get(i) == Status.FREE) {
                countAdress[a] = i;
                a++;
                map.put(i, Status.ALLOCATED);
            }

            if (a == countClusters) {
                break;
            }
        }

        return new Allocation(countAdress, countSize);
    }

    //------------------------< Getter >---------------------------
    public int getTotalSize() {
        return this.totalSize;
    }

    public int getUsedSize() {
        return this.usedSize;
    }

    public int getClusterSize() {
        return this.clusterSize;
    }

    //------------------------< Methoden >------------------------

    public void free(final Allocation allocation) {
        for (int i = 0; i < allocation.getAdress().length; i++) {
            map.put(allocation.getAdress()[i], Status.FREE);
        }
    }

    public String toString() {
        return "MemorySimple[Belegt:" + usedSize + "; Frei: " + (totalSize - usedSize) + "]";
    }

    public String getAllocations(){
        String allocations = "";
        for (int i = 0; i < totalSize; i += clusterSize) {
            allocations += map.get(i);
            allocations += "\n";
        }
        return allocations;
    }
}

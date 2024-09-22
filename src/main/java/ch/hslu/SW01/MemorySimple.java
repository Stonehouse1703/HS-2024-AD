package ch.hslu.SW01;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MemorySimple implements Memory{

    //------------------------< Attribute >-------------------------
    private int totalSize;
    private int usedSize;
    private int clusterSize;

    final Map<Integer, Status> map = new HashMap<>();

    //------------------------< Konstruktor >------------------------


    private MemorySimple(final int totalSize, final int clusterSize, int usedSize) {
        if (totalSize <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        if(clusterSize <= 0) {
            throw new IllegalArgumentException("ClusterSize must be greater than 0");
        }

        if(usedSize > totalSize) {
            throw new IllegalArgumentException("No more memory left");
        }

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

        //  überprüft, ob der Speicher nicht 0 ist
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }

        //  überprüft, ob genügend speicher vorhanden ist
        if (usedSize + size > totalSize) {
            throw new IllegalArgumentException("Mem");
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

        //  Überprüft, ob der Speicher größer als 1 cluster ist, falls nein, wird der Speicher in einem cluster aufgeteilt
        while (size >= clusterSize){
            countSize[s] = clusterSize;
            s++;
            size -= clusterSize;
            usedSize += clusterSize;
        }
        usedSize += clusterSize;
        countSize[s] = size;

        //  Überprüft, die Clusterplätze und ordnet die Cluster zu
        for (int i = 0; i < totalSize; i += clusterSize) {
            if (map.get(i) == Status.FREE) {
                countAdress[a] = i;
                a++;
                map.put(i, Status.ALLOCATED);
            }

            // Falls die Cluster verteilt sind, sollte die Schleife beendet werden
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
            usedSize -= clusterSize;
        }
    }

    public String getAllocations(){
        String allocations = "";
        for (int i = 0; i < totalSize; i += clusterSize) {
            allocations += map.get(i);
            allocations += "\n";
        }
        return allocations;
    }

    public String toString() {
        return "MemorySimple[Belegt:" + usedSize + "; Frei: " + (totalSize - usedSize) + "]";
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof MemorySimple that)
                && totalSize == that.totalSize
                && usedSize == that.usedSize
                && clusterSize == that.clusterSize
                && Objects.equals(map, that.map)
                ;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(totalSize, usedSize, clusterSize, map);
    }
}

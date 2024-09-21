package ch.hslu.SW01;

public interface Memory {

    public int getTotalSize();
    public int getUsedSize();
    public int getClusterSize();

    public Allocation malloc(final int size);

    public String toString();

    public void free(final Allocation allocation);

    public String getAllocations();
}

package ch.hslu.SW01;

public interface Memory {

    Allocation malloc(int size);
    public int freeSize();
    public void free(Allocation allocation);
    public boolean equals(Object o);
    public int hashCode();
    public String toString();
}

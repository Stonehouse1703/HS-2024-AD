package ch.hslu.SW01;

public interface Memory {

    Allocation malloc(int size);

    String toString();

    void free(Allocation block1);
}

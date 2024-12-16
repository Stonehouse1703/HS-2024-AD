package ch.hslu.sw03.Bäume;

public interface Leaf<T> {

    public T getRight();
    public T getLeft();
    public T getElement();
    public void addLeaf(T leaf);
    public void removeLeafright();
    public void removeLeafleft();
}

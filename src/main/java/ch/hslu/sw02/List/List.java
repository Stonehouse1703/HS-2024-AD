package ch.hslu.sw02.List;

public class List<T> {

    private int size;
    private Node head;

    public List(){
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public void addElement(T element){
        size++;
        Node<T> newNode = new Node(element);
        if (size <= 1){
            newNode.setNext(null);
        } else {
            newNode.setNext(head);
        }
        this.head = newNode;
    }

    public String peekHead(){
        return head.peekNext();
    }

    public Node remove(){
        size--;
        Node copieHead = head;
        head = head.getNext();
        return copieHead;
    }

    public void getList(){
        Node copieHead = head;
        for (int i = 1; i <= size; i++){
            System.out.println(i + " -> " + copieHead.peekNext());
            copieHead = copieHead.getNext();
        }
    }
}

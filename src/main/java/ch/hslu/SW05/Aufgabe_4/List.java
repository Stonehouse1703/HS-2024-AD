package ch.hslu.SW05.Aufgabe_4;

public class List<T> {

    private int size;
    private Node<T> header;

    public List(){
        size = 0;
        header = null;
    }

    public Node getHeader(){
        return header;
    }

    public void addObject(T object){
        Node<T> newObject = new Node<>(object);
        if(header != null){
            newObject.setNext(header);
        }
        header = newObject;
        size++;
    }

    public void remove (T object) {
        if (size == 0){
            throw new IllegalArgumentException("Kein Objekt ist in der Liste enthalten");
        }

        // Falls das Objekt das erste Element der Liste ist
        if (header.getObject().equals(object)) {
            header = header.getNext();
            size--;
            return;
        }

        // Andernfalls das Objekt im Rest der Liste suchen
        Node<T> currentObject = header;
        Node<T> previousObject = null;

        while (currentObject != null && !currentObject.getObject().equals(object)) {
            previousObject = currentObject;
            currentObject = currentObject.getNext();
        }

        // Falls das Objekt nicht gefunden wurde
        if (currentObject == null) {
            throw new IllegalArgumentException("Das Objekt ist nicht in der Liste enthalten");
        }

        // Objekt entfernen
        if (previousObject != null) {
            previousObject.setNext(currentObject.getNext());
        }

        size--;
    }

    @Override
    public String toString() {
        Node<T> currentObject = header;
        StringBuilder wert = new StringBuilder("List{ size=" + size + " Elemente: ");

        // Schleife durch die Liste
        while (currentObject != null) {
            wert.append(currentObject.toString()).append(" ");
            currentObject = currentObject.getNext();
        }

        wert.append(" }");
        return wert.toString();
    }
}

package ch.hslu.SW04.Aufgabe_05;

public class Tree<T> {

    //------------< Attribute >------------
    Inhalt knoten;
    int size;
    int hight;

    //------------< Konstruktor >------------
    public Tree(){
        this.knoten = null;
        this.size = -1;
        this.hight = -1;
    }

    //------------< Methoden >------------
    public int getSize(){
        return this.size;
    }

    public int getHight(){
        return this.hight;
    }

    public void addToTree(int data) {
        if (size < 0) {
            // Create the root node if the tree is empty
            Inhalt newData = new Inhalt(data);
            this.knoten = newData;
            size++;
            hight++;
        } else {
            Inhalt current = knoten;
            Inhalt parent = null;
            int currentHight = 0;

            // Traverse the tree to find the correct position
            while (current != null) {
                parent = current;
                if (data < current.getData()) {
                    current = current.getLeft();  // Move left
                    currentHight++;
                } else if (data > current.getData()) {
                    current = current.getRight();  // Move right
                    currentHight++;
                } else {
                    // Data already exists in the tree, do not insert duplicates
                    throw new IllegalArgumentException("Inhalt bereits vorhanden");
                }
            }

            // At this point, 'current' is null and 'parent' is the node where the new node should be added
            Inhalt newData = new Inhalt(data);
            if (data < parent.getData()) {
                parent.setLeft(newData);  // Add as the left child
            } else {
                parent.setRight(newData);  // Add as the right child
            }

            size++;
            if(currentHight > hight){
                hight = currentHight;
            }
        }
    }

    public void search(int data){

        if (knoten == null){
            throw new IllegalArgumentException("aktuell sind keine Elemente vorhanden");
        }

        String pfad = "";

        Inhalt current = knoten;

        while (data != current.getData()){
            if (data < current.getData()){
                pfad += "links - ";
                current = current.getLeft();
            } else if (data > current.getData()){
                pfad += "rechts - ";
                current = current.getRight();
            }
        }

        System.out.println("Der gesuchte Inhalt: " + data + " hat folgenden Pfad: " + pfad);
    }

}

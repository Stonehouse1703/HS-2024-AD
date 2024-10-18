package ch.hslu.SW05.Aufgabe_3;

public class Hashtabelle<T> {

    private T[] array;
    private T platzhalter;

    public Hashtabelle(int size){
        this.array = (T[]) new Object[size];
        this.platzhalter = (T) new Zahl(Integer.MAX_VALUE);
    }

    public void addObject(T object){
        int index = hashIndex(object);

        if (array[index] == null){
            array[index] = object;
        } else {
            while (array[index] != null){
                index++;
                if (index >= array.length){
                    index = 0;
                }
                if (index == hashIndex(object)){
                    throw new IllegalArgumentException("Hat keinen Platz mehr");
                }
            }
            array[index] = object;
        }
    }

    public boolean objectVorhanden(T object){
        int index = hashIndex(object);

        if (array[index] == null){
            return false;
        }

        while (!(object.equals(array[index]))){
            index++;
            if(index >= array.length){
                index = 0;
            }

            if(array[index] == null){
                return false;
            }
        }
        return true;
    }

    public void removeObject(T object){
        int index = findIndexFromObject(object);
        if (array[index + 1] == null ){
            array[index] = null;
            while (platzhalter.equals(array[index - 1])){
                array[index - 1] = null;
                index--;
            }
        } else {
            array[index] = platzhalter;
        }
    }

    private int findIndexFromObject(T object){

        if (!(objectVorhanden(object))){
            throw new IllegalArgumentException("Object nicht vorhanden");
        }

        int index = hashIndex(object);

        while (!(object.equals(array[index]))){
            index++;
            if(index >= array.length){
                index = 0;
            }
        }
        return index;
    }

    private boolean sameObject(T object){
        int index = hashIndex(object);
        return object.equals(array[index]);
    }

    private int hashIndex(T object){
        return object.hashCode() % array.length;
    }

    @Override
    public String toString() {
        String wert = "";

        for (int i = 0; i < array.length; i++){
            wert += "Index: " + i + " Wert = ";
            if (array[i] == null){
                wert += "null \n";
            } else {
                wert += array[i].toString() + "\n";
            }
        }

        return wert;
    }
}

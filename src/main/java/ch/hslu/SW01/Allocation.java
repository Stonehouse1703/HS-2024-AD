package ch.hslu.SW01;

import java.util.Arrays;

public final class Allocation implements Comparable {

   //------------------------< Attribute >-------------------------
   private final int[] adress;
   private final int[] size;

   //------------------------< Konstruktor >------------------------
   public Allocation(final int[] adress, final int[] size) {
       this.adress = adress;
       this.size = size;
   }

   //------------------------< Getter >---------------------------
   public String getAdressString() {
       return Arrays.toString(adress);
   }

   public String getSizeString() {
       return Arrays.toString(size);
   }

    public int[] getAdress() {
        return this.adress;
    }

    public int[] getSize() {
        return this.size;
    }

   public String toString() {
       return "Allocation[Adresse:" + getAdressString() + "; Size:" + getSizeString() + "]";
   }
}


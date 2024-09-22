package ch.hslu.SW01;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public final boolean equals(final Object o) {
        if (this == o) return true;
        return (o instanceof Allocation that)
                && Arrays.equals(adress, that.adress)
                && Arrays.equals(size, that.size)
                ;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(Arrays.hashCode(adress), Arrays.hashCode(size));
    }
}


package ch.hslu.SW01;

import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

public class AllocationTest {

    @Test
    public void testGetAdressStringMultiplyPossition() {
        Allocation allo = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertEquals("[1, 2, 3]", allo.getAdressString());
    }

    @Test
    public void testGetAdressStringOnePossition() {
        Allocation allo = new Allocation(new int[]{7}, new int[]{4});
        assertEquals("[7]", allo.getAdressString());
    }

    @Test
    public void testGetSizeStringMultiplyPossition() {
        Allocation allo = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertEquals("[4, 5, 6]", allo.getSizeString());
    }

    @Test
    public void testGetSizeStringOnePossition() {
        Allocation allo = new Allocation(new int[]{7}, new int[]{1});
        assertEquals("[1]", allo.getSizeString());
    }

    @Test
    public void testGetAdressMultiplyPossition() {
        Allocation allo = new Allocation(new int[]{6, 8, 1}, new int[]{4, 5, 6});
        assertArrayEquals(new int[]{6, 8, 1}, allo.getAdress());
    }

    @Test
    public void testGetAdressOnePossition() {
        Allocation allo = new Allocation(new int[]{7}, new int[]{4});
        assertArrayEquals(new int[]{7}, allo.getAdress());
    }

    @Test
    public void testGetSizeMultiplyPossition() {
        Allocation allo = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertArrayEquals(new int[]{4, 5, 6}, allo.getSize());
    }

    @Test
    public void testGetSizeOnePossition() {
        Allocation allo = new Allocation(new int[]{7}, new int[]{12});
        assertArrayEquals(new int[]{12}, allo.getSize());
    }

    @Test
    public void testToString() {
        Allocation allo = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertEquals("Allocation[Adresse:[1, 2, 3]; Size:[4, 5, 6]]", allo.toString());
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Allocation.class).verify();
    }

    @Test
    void testHashCode() {
        Allocation allo1 = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        Allocation allo2 = new Allocation(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        Allocation allo3 = new Allocation(new int[]{1, 2, 4}, new int[]{4, 5, 6});
        assertEquals(allo1.hashCode(), allo2.hashCode());
        assertNotEquals(allo1.hashCode(), allo3.hashCode());
    }
}

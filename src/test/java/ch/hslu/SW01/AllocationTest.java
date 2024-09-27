package ch.hslu.SW01;

import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.*;

public class AllocationTest {

    @Test
    public void testGetAdressNormalSize() {
        Allocation allocation = new Allocation(30, 20, 1);
        assertEquals(30, allocation.getAdress());
        assertEquals(20, allocation.getSize());
    }

    @Test
    public void testGetZeroSize() {
        Allocation allocation = new Allocation(0, 0,1 );
        assertEquals(0, allocation.getAdress());
        assertEquals(0, allocation.getSize());
    }

    @Test
    public void testExceptionHandlingWithAssertJSize() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Allocation(-233, 43,1 );
        });
        assertTrue(exception.getMessage().contains("Adress and size must be greater than 0"));
    }

    @Test
    public void testExceptionHandlingWithAssertJAdress() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Allocation(233, -43,1 );
        });
        assertTrue(exception.getMessage().contains("Adress and size must be greater than 0"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testHashCode() {
        Allocation allocation = new Allocation(14, 50,1);
        Allocation allocation2 = new Allocation(14, 50,1 );
        Allocation allocation3 = new Allocation(3, 50,1 );
        assertEquals(allocation.hashCode(), allocation2.hashCode());
        assertNotEquals(allocation.hashCode(), allocation3.hashCode());
    }

    @Test
    public void testToString() {
        Allocation allocation = new Allocation(14, 50,1);
        assertEquals("Allocation [Adresse: 14; Size: 50]", allocation.toString());
    }
}

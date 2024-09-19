package ch.hslu.SW01;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemorySimpleTest {

    @Test
    public void testFreeSizeTo0() {
        MemorySimple memorySimple = new MemorySimple(1000);
        memorySimple.malloc(500);
        memorySimple.malloc(500);
        assertEquals(0, memorySimple.freeSize());
    }
    @Test
    public void testFreeSizeTotal() {
        MemorySimple memorySimple = new MemorySimple(1024);
        assertEquals(1024, memorySimple.freeSize());
    }

    @Test
    public void testExceptionHandlingWithAssertJAllocation0() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MemorySimple memorySimple = new MemorySimple(10);
            memorySimple.malloc(0);
        });
        assertTrue(exception.getMessage().contains("Invalid size, must be greater than 0"));
    }

    @Test
    public void testExceptionHandlingWithAssertJFull() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MemorySimple memorySimple = new MemorySimple(10);
            memorySimple.malloc(11);
        });
        assertTrue(exception.getMessage().contains("Not enough memory available to allocate"));
    }

    @Test
    public void testExceptionHandlingWithAssertJHarddiskSize0() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MemorySimple(0);
        });
        assertTrue(exception.getMessage().contains("Invalid size, must be greater than 0"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(MemorySimple.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testHashCode() {
        MemorySimple memorySimple = new MemorySimple(1024);
        MemorySimple memorySimple2 = new MemorySimple(1024);
        MemorySimple memorySimple3 = new MemorySimple(5);
        assertEquals(memorySimple.hashCode(), memorySimple2.hashCode());
        assertNotEquals(memorySimple.hashCode(), memorySimple3.hashCode());
    }

    @Test
    public void testToString() {
        MemorySimple memorySimple = new MemorySimple(1024);
        assertEquals("MemorySimple [Belegt: 0; Gesamt: 1024]", memorySimple.toString());
    }
}

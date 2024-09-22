package ch.hslu.SW01;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemorySimpleTest {

    @Test
    public void testExceptionHandlingWithAssertJCluster0() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MemorySimple(10, 0);
        });
        assertTrue(exception.getMessage().contains("ClusterSize must be greater than 0"));
    }

    @Test
    public void testExceptionHandlingWithAssertJSize0() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new MemorySimple(0, 512);
        });
        assertTrue(exception.getMessage().contains("Size must be greater than 0"));
    }

    @Test
    public void testExceptionHandlingWithAssertJMallocSize0() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Memory memSip = new MemorySimple(6000, 512);
            memSip.malloc(0);
        });
        assertTrue(exception.getMessage().contains("Size must be greater than 0"));
    }

    @Test
    public void testExceptionHandlingWithAssertJMallocUsedSizeFull() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Memory memSip = new MemorySimple(3, 512);
            memSip.malloc(10);
        });
        assertTrue(exception.getMessage().contains("No more memory left"));
    }

    @Test
    public void getTotalSize() {
        MemorySimple memSip = new MemorySimple(6000, 512);
        assertEquals(6000, memSip.getTotalSize());
    }

    @Test
    public void getUsedSize0() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        assertEquals(0, memSip.getUsedSize());
    }

    @Test
    public void getUsedSizeOver0() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        Allocation block1 = memSip.malloc(3);
        assertEquals(512, memSip.getUsedSize());
    }

    @Test
    public void getUsedSizeAllUsed() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        Allocation block1 = memSip.malloc(3000);
        assertEquals(3072, memSip.getUsedSize());
    }

    @Test
    public void getClusterSize() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        assertEquals(512, memSip.getClusterSize());
    }

    @Test
    public void testfree() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        Allocation block1 = memSip.malloc(6);
        assertEquals(512, memSip.getUsedSize());
        memSip.free(block1);
        assertEquals(0, memSip.getUsedSize());
    }

    @Test
    public void testGetAllocationsAllFree() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        assertEquals("FREE\nFREE\nFREE\nFREE\nFREE\nFREE\n", memSip.getAllocations());
    }

    @Test
    public void testGetAllocationsFirstUsed() {
        MemorySimple memSip = new MemorySimple(3072, 512);
        memSip.malloc(6);
        assertEquals("ALLOCATED\nFREE\nFREE\nFREE\nFREE\nFREE\n", memSip.getAllocations());
    }

    @Test
    public void testToString() {
        MemorySimple MemSip = new MemorySimple(3072, 512);
        assertEquals("MemorySimple[Belegt:0; Frei: 3072]", MemSip.toString());
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(MemorySimple.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testHashCode() {
        MemorySimple MemSip1 = new MemorySimple(3072, 512);
        MemorySimple MemSip2 = new MemorySimple(3072, 512);
        MemorySimple MemSip3 = new MemorySimple(1024, 512);
        assertEquals(MemSip1.hashCode(), MemSip2.hashCode());
        assertNotEquals(MemSip1.hashCode(), MemSip3.hashCode());
    }
}

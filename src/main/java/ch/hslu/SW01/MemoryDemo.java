package ch.hslu.SW01;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public final class MemoryDemo {

    private static final Logger LOG = LoggerFactory.getLogger(MemoryDemo.class);

    public static void main(final String[] args) {

        try{
            // Festplatte mit 1024 Bytes erstellen
            final Memory memory = new MemorySimple(1024);
            System.out.println(memory);
            LOG.info(memory.toString());
            System.out.println(memory);

            // Erste Allokation von 16 Bytes
            final Allocation block1 = memory.malloc(16);
            LOG.info(block1.toString());
            LOG.info(memory.toString());

            // Zweite Allokation von 8 Bytes
            final Allocation block2 = memory.malloc(8);
            LOG.info(block2.toString());
            LOG.info(memory.toString());

            // Speicherfreigabe des ersten Blocks
            memory.free(block1);
            LOG.info(memory.toString());
        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage());
        }
    }
}

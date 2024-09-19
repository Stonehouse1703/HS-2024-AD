package ch.hslu.SW01;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public final class MemoryDemo {

    private static final Logger LOG = LoggerFactory.getLogger(MemoryDemo.class);

    public static void main(final String[] args) {

        try{
            // Festplatte mit 1024 Bytes erstellen
            final Memory memory = new MemorySimple(5000);
            System.out.println(memory);
            LOG.info(memory.toString());

            // Erste Allokation von 16 Bytes
            final Allocation block1 = memory.malloc(1000);
            LOG.info(block1.toString());
            LOG.info(memory.toString());

            // Zweite Allokation von 8 Bytes
            final Allocation block2 = memory.malloc(8);
            LOG.info(block2.toString());
            LOG.info(memory.toString());


            final Allocation block3 = memory.malloc(8);
            LOG.info(block3.toString());
            LOG.info(memory.toString());


            // Speicherfreigabe des ersten Blocks
            memory.free(block1);
            LOG.info(memory.toString());


            final Allocation block4 = memory.malloc(1000);
            LOG.info(block4.toString());
            LOG.info(memory.toString());

            for (int i = 1; i <= memory.getSizeMap(); i++) {
                System.out.println(memory.getStatus(i));
            }

        } catch (IllegalArgumentException e) {
            LOG.error(e.getMessage());
        }
    }
}

package ch.hslu.SW01;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public final class MemoryDemo {

    private static final Logger LOG = LoggerFactory.getLogger(MemoryDemo.class);

    public static void main(final String[] args) {
        try {
            final Memory memory = new MemorySimple(3072, 512);
            LOG.info(memory.toString());
            final Allocation block1 = memory.malloc(600);
            LOG.info(block1.toString());
            LOG.info(memory.toString());
            final Allocation block2 = memory.malloc(8);
            LOG.info(block2.toString());
            LOG.info(memory.toString());
            memory.free(block1);
            System.out.println(memory.getAllocations());
            final Allocation block4 = memory.malloc(4);
            LOG.info(block4.toString());
            LOG.info(memory.toString());
            System.out.println(memory.getAllocations());
        } catch (final Exception e) {
            LOG.error(e.getMessage());
        }
    }
}

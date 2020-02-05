package by.kiselevich.task1.factory;

import org.junit.Assert;
import org.junit.Test;

public class ToyRepositoryFactoryTest extends Assert {

    @Test
    public void getInstanceTest() {
        assertSame(ToyRepositoryFactory.getInstance(), ToyRepositoryFactory.getInstance());
    }

    @Test
    public void getToyRepositoryTest() {
        ToyRepositoryFactory factory = ToyRepositoryFactory.getInstance();
        assertSame(factory.getToyRepository(), factory.getToyRepository());
    }
}

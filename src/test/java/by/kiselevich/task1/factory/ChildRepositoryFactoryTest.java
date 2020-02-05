package by.kiselevich.task1.factory;

import org.junit.Assert;
import org.junit.Test;

public class ChildRepositoryFactoryTest extends Assert {

    @Test
    public void getInstanceTest() {
        assertSame(ChildRepositoryFactory.getInstance(), ChildRepositoryFactory.getInstance());
    }

    @Test
    public void getChildRepositoryTest() {
        ChildRepositoryFactory factory = ChildRepositoryFactory.getInstance();
        assertSame(factory.getChildRepository(), factory.getChildRepository());
    }
}

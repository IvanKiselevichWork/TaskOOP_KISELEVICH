package by.kiselevich.task1.factory;

import by.kiselevich.task1.repository.child.ChildRepository;
import by.kiselevich.task1.repository.child.ChildRepositoryImpl;

public class ChildRepositoryFactory {

    private final ChildRepository childRepository = new ChildRepositoryImpl();

    private ChildRepositoryFactory() {

    }

    private static class ChildRepositoryFactoryHolder {
        private static final ChildRepositoryFactory INSTANCE = new ChildRepositoryFactory();
    }

    public static ChildRepositoryFactory getInstance() {
        return ChildRepositoryFactoryHolder.INSTANCE;
    }

    public ChildRepository getChildRepository() {
        return childRepository;
    }
}

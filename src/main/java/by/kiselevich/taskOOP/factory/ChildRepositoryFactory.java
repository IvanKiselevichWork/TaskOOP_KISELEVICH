package by.kiselevich.taskOOP.factory;

import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.repository.impl.ArrayListChildRepository;

public class ChildRepositoryFactory {
    private ChildRepositoryFactory() {

    }

    private static class ChildRepositoryFactoryHolder {
        private static final ChildRepositoryFactory instance = new ChildRepositoryFactory();
    }

    public static ChildRepositoryFactory getInstance() {
        return ChildRepositoryFactoryHolder.instance;
    }

    public ChildRepository getChildRepository() {
        return new ArrayListChildRepository();
    }
}

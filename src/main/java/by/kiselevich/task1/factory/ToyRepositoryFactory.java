package by.kiselevich.task1.factory;

import by.kiselevich.task1.repository.toy.ToyRepository;
import by.kiselevich.task1.repository.toy.ToyRepositoryImpl;

public class ToyRepositoryFactory {

    private final ToyRepository toyRepository = new ToyRepositoryImpl();

    private ToyRepositoryFactory() {

    }

    private static class ToyRepositoryFactoryHolder {
        private static final ToyRepositoryFactory INSTANCE = new ToyRepositoryFactory();
    }

    public static ToyRepositoryFactory getInstance() {
        return ToyRepositoryFactory.ToyRepositoryFactoryHolder.INSTANCE;
    }

    public ToyRepository getToyRepository() {
        return toyRepository;
    }
}

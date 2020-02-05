package by.kiselevich.task1.factory;

import by.kiselevich.task1.repository.ToyRepository;
import by.kiselevich.task1.repository.impl.ArrayListToyRepository;

public class ToyRepositoryFactory {

    private final ToyRepository toyRepository = new ArrayListToyRepository();

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

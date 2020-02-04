package by.kiselevich.task1.factory;

import by.kiselevich.task1.repository.ToyRepository;
import by.kiselevich.task1.repository.impl.ArrayListToyRepository;

public class ToyRepositoryFactory {
    private ToyRepositoryFactory() {

    }

    private static class ToyRepositoryFactoryHolder {
        private static final ToyRepositoryFactory instance = new ToyRepositoryFactory();
    }

    public static ToyRepositoryFactory getInstance() {
        return ToyRepositoryFactory.ToyRepositoryFactoryHolder.instance;
    }

    public ToyRepository getToyRepository() {
        return new ArrayListToyRepository();
    }
}

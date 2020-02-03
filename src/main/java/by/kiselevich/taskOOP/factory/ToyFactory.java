package by.kiselevich.taskOOP.factory;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.entity.toy.ToyType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ToyFactory {

    private ToyFactory() {

    }

    private static class ToyFactoryHolder {
        private static final ToyFactory instance = new ToyFactory();
    }

    public static ToyFactory getInstance() {
        return ToyFactory.ToyFactoryHolder.instance;
    }
    
    public List<Toy> getToys(ToyType toyType, ToySize toySize, BigDecimal cost, int count) {
        List<Toy> toys = new ArrayList<>(count);
        IntStream.range(0, count).forEach(i -> toys.add(new Toy(toyType, toySize, cost)));
        return toys;
    }
}

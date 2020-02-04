package by.kiselevich.task1.factory;

import by.kiselevich.task1.entity.toy.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ToyFactory {

    private ToyFactory() {

    }

    private static class ToyFactoryHolder {
        private static final ToyFactory INSTANCE = new ToyFactory();
    }

    public static ToyFactory getInstance() {
        return ToyFactoryHolder.INSTANCE;
    }
    
    public List<Toy> createToys(ToyType toyType, ToySize toySize, BigDecimal cost, int count) {
        List<Toy> toys = new ArrayList<>(count);
        IntStream.range(0, count).forEach(i -> toys.add(createConcreteToyFromType(toyType, toySize, cost)));
        return toys;
    }

    private Toy createConcreteToyFromType(ToyType toyType, ToySize toySize, BigDecimal cost) {
        Toy toy = null;
        switch (toyType) {
            case BALL:
                toy = new Ball(toySize, cost);
                break;
            case CAR:
                toy = new Car(toySize, cost);
                break;
            case CUBE:
                toy = new Cube(toySize, cost);
                break;
            case DOLL:
                toy = new Doll(toySize, cost);
                break;
        }
        return toy;
    }
}

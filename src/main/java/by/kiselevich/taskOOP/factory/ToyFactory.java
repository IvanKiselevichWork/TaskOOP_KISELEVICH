package by.kiselevich.taskOOP.factory;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.entity.toy.ToyType;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class ToyFactory {
    public Toy[] getToys(ToyType toyType, ToySize toySize, BigDecimal cost, int count) {
        Toy[] toys = new Toy[count];
        IntStream.range(0, count).forEach(i -> toys[i] = new Toy(toyType, toySize, cost));
        return toys;
    }
}

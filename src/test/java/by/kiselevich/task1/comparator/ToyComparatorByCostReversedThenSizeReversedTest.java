package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.toy.Ball;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class ToyComparatorByCostReversedThenSizeReversedTest extends Assert {

    @Test
    public void compareToysByCostTest() {
        Comparator<Toy> comparator = new ToyComparatorByCostReversedThenSizeReversed();
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.SMALL, BigDecimal.valueOf(20), ToyType.BALL);
        assertTrue(comparator.compare(toy1, toy2) > 0);
        assertTrue(comparator.compare(toy2, toy1) < 0);
    }

    @Test
    public void compareToysBySizeTest() {
        Comparator<Toy> comparator = new ToyComparatorByCostReversedThenSizeReversed();
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.BIG, BigDecimal.valueOf(10), ToyType.BALL);
        assertTrue(comparator.compare(toy1, toy2) > 0);
        assertTrue(comparator.compare(toy2, toy1) < 0);
    }
}

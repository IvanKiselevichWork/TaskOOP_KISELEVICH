package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.entity.toy.Ball;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import by.kiselevich.task1.repository.toy.ToyRepository;
import by.kiselevich.task1.repository.toy.ToyRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class GetAllToysSortedByCostTest extends Assert {
    @Test
    public void compareToysByCostTest() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.SMALL, BigDecimal.valueOf(20), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.addAll(Arrays.asList(toy1, toy2));
        List<Toy> toyList = toyRepository.query(new GetAllToysSortedByCost());
        assertEquals(toyList.get(0), toy1);
        assertEquals(toyList.get(1), toy2);
    }
}

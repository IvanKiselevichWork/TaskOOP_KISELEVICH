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

public class GetToysForSummaryCostWithSizesTest extends Assert {
    @Test
    public void getToysForSummaryCostWithSizesTest1() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(20), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.BIG, BigDecimal.valueOf(20), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.addAll(Arrays.asList(toy1, toy2));
        List<Toy> toyList = toyRepository.query(new GetToysForSummaryCostWithSizes(BigDecimal.valueOf(100), ToySize.SMALL));
        assertEquals(1, toyList.size());
        assertEquals(toy1, toyList.get(0));
        assertEquals(BigDecimal.valueOf(20), getSumCost(toyList));
    }

    @Test
    public void getToysForSummaryCostTest2() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(20), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.BIG, BigDecimal.valueOf(20), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.addAll(Arrays.asList(toy1, toy2));
        List<Toy> toyList = toyRepository.query(new GetToysForSummaryCostWithSizes(BigDecimal.valueOf(100), ToySize.MEDIUM));
        assertEquals(0, toyList.size());
    }

    private BigDecimal getSumCost(List<Toy> toys) {
        BigDecimal cost = new BigDecimal(0);
        for (Toy toy : toys) {
            cost = cost.add(toy.getCost());
        }
        return cost;
    }
}

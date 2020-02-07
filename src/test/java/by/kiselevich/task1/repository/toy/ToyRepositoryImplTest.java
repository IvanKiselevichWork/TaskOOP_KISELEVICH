package by.kiselevich.task1.repository.toy;

import by.kiselevich.task1.entity.toy.Ball;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ToyRepositoryImplTest extends Assert {

    @Test
    public void addAllGetAllTest() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.BIG, BigDecimal.valueOf(10), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.addAll(Arrays.asList(toy1, toy2));
        List<Toy> toyList = toyRepository.getAll();
        assertEquals(2, toyList.size());
        assertTrue(toyList.contains(toy1));
        assertTrue(toyList.contains(toy2));
    }

    @Test
    public void addTest() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.add(toy1);
        List<Toy> toyList = toyRepository.getAll();
        assertEquals(1, toyList.size());
        assertTrue(toyList.contains(toy1));
    }

    @Test
    public void removeTest() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        Toy toy2 = new Ball(ToySize.BIG, BigDecimal.valueOf(10), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.addAll(Arrays.asList(toy1, toy2));
        toyRepository.remove(toy1);
        List<Toy> toyList = toyRepository.getAll();
        assertEquals(1, toyList.size());
        assertTrue(toyList.contains(toy2));
    }

    @Test
    public void updateTest() {
        Toy toy1 = new Ball(ToySize.SMALL, BigDecimal.valueOf(10), ToyType.BALL);
        ToyRepository toyRepository = new ToyRepositoryImpl();
        toyRepository.add(toy1);
        toy1.setCost(BigDecimal.valueOf(20));
        toyRepository.update(toy1);
        List<Toy> toyList = toyRepository.getAll();
        assertEquals(1, toyList.size());
        assertTrue(toyList.contains(toy1));
    }
}

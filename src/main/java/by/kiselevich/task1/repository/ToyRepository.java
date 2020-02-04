package by.kiselevich.task1.repository;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;

import java.math.BigDecimal;
import java.util.List;

public interface ToyRepository {

    void addToys(List<Toy> toys);
    List<Toy> getToysForSummaryCostWithSizes(BigDecimal cost, ToySize ... toySizes);
}

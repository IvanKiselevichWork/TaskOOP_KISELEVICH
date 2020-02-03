package by.kiselevich.taskOOP.repository;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;

import java.math.BigDecimal;
import java.util.List;

public interface ToyRepository {

    void addToys(List<Toy> toys);
    List<Toy> getToysForSummaryCostWithSizes(BigDecimal cost, ToySize ... toySizes);
}

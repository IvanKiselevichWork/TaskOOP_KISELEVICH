package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.comparator.ToyComparatorByCostReversedThenSizeReversed;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.repository.Repository;

import java.math.BigDecimal;
import java.util.*;

public class GetAllToySortedByCostReversedThenSizeReversed implements ToySpecification {

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = repository.getAll();
        result.sort(new ToyComparatorByCostReversedThenSizeReversed());
        return result;
    }
}

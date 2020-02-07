package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.comparator.ToyComparatorByCost;
import by.kiselevich.task1.comparator.ToyComparatorBySize;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.repository.Repository;

import java.util.List;

public class GetAllToysSortedBySize implements ToySpecification {

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = repository.getAll();
        result.sort(new ToyComparatorBySize());
        return result;
    }
}

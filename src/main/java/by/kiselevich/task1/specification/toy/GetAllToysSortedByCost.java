package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.comparator.ToyComparatorByCost;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.repository.Repository;

import java.util.List;

public class GetAllToysSortedByCost implements ToySpecification {

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = repository.getAll();
        result.sort(new ToyComparatorByCost());
        return result;
    }
}

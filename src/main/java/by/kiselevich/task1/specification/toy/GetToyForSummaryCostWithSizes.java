package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.repository.Repository;

import java.math.BigDecimal;
import java.util.*;

public class GetToyForSummaryCostWithSizes implements ToySpecification {

    private BigDecimal cost;
    private Set<ToySize> sizes;

    public GetToyForSummaryCostWithSizes(BigDecimal cost, ToySize ... sizes) {
        this.cost = cost;
        this.sizes = EnumSet.copyOf(Arrays.asList(sizes));
    }

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = new ArrayList<>();
        Iterator<Toy> iterator = repository.query(new GetAllToysSortedByCostReversedThenSizeReversed()).iterator();
        while(iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getCost().compareTo(cost) < 0 && sizes.contains(toy.getSize())) {
                cost = cost.subtract(toy.getCost());
                result.add(toy);
                iterator.remove();
            }
        }
        return result;
    }
}

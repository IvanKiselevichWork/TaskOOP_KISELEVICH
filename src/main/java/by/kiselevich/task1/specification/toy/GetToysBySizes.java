package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.repository.Repository;

import java.math.BigDecimal;
import java.util.*;

public class GetToysBySizes implements ToySpecification {

    private Set<ToySize> sizes;

    public GetToysBySizes(ToySize ... sizes) {
        this.sizes = EnumSet.copyOf(Arrays.asList(sizes));
    }

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : repository.getAll()) {
            if (sizes.contains(toy.getSize())) {
                result.add(toy);
            }
        }
        return result;
    }
}

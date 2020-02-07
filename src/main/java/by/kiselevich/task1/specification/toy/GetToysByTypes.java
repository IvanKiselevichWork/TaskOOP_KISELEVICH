package by.kiselevich.task1.specification.toy;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import by.kiselevich.task1.repository.Repository;

import java.math.BigDecimal;
import java.util.*;

public class GetToysByTypes implements ToySpecification {

    private Set<ToyType> toyTypes;

    public GetToysByTypes(ToyType ... toyTypes) {
        this.toyTypes = EnumSet.copyOf(Arrays.asList(toyTypes));
    }

    @Override
    public List<Toy> query(Repository<Toy> repository) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : repository.getAll()) {
            if (toyTypes.contains(toy.getToyType())) {
                result.add(toy);
            }
        }
        return result;
    }
}

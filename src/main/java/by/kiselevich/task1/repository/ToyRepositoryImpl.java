package by.kiselevich.task1.repository;

import by.kiselevich.task1.comparator.ToyComparatorByCostReversedThenSizeReversed;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.repository.ToyRepository;

import java.math.BigDecimal;
import java.util.*;

public class ToyRepositoryImpl implements ToyRepository {

    private List<Toy> toys = new ArrayList<>();

    @Override
    public void addToys(List<Toy> toys) {
        this.toys.addAll(toys);
        toys.sort(new ToyComparatorByCostReversedThenSizeReversed());
    }

    /**
     *
     * @param cost max sum cost
     * @param toySizes ToySize array
     * @return toys list
     */
    @Override
    public List<Toy> getToysForSummaryCostWithSizes(BigDecimal cost, ToySize... toySizes) {

        List<Toy> result = new ArrayList<>();
        Set<ToySize> sizes = EnumSet.copyOf(Arrays.asList(toySizes));
        Iterator<Toy> iterator = toys.iterator();
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

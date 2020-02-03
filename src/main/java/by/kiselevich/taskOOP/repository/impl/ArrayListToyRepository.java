package by.kiselevich.taskOOP.repository.impl;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.repository.ToyRepository;

import java.math.BigDecimal;
import java.util.*;

public class ArrayListToyRepository implements ToyRepository {

    final List<Toy> toys = new ArrayList<>();

    @Override
    public synchronized void addToys(List<Toy> toys) {
        this.toys.addAll(toys);
    }

    /**
     *
     * @param cost max sum cost
     * @param toySizes ToySize array
     * @return toys list
     */
    @Override
    public synchronized List<Toy> getToysForSummaryCostWithSizes(BigDecimal cost, ToySize... toySizes) {

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

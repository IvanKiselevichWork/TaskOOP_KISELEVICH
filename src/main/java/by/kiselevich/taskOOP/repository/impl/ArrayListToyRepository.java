package by.kiselevich.taskOOP.repository.impl;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.*;

public class ArrayListToyRepository implements ToyRepository {

    private final static Logger logger = LogManager.getLogger(ArrayListToyRepository.class);

    List<Toy> toys = new ArrayList<>();

    @Override
    public synchronized void addToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public synchronized boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    @Override
    public synchronized void addToys(List<Toy> toys) {
        this.toys.addAll(toys);
    }

    @Override
    public synchronized List<Toy> getAllToys() {
        return new ArrayList<>(toys);
    }

    /**
     *
     * @param cost max sum cost
     * @param toySizes ToySize array
     * @return toys list
     */
    @Override
    public synchronized List<Toy> getToysForSummaryCostWithSizesAndReturnTrifle(BigDecimal cost, ToySize... toySizes) {

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

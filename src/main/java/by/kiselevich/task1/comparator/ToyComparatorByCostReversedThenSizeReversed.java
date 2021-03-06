package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.toy.Toy;

import java.util.Comparator;

public class ToyComparatorByCostReversedThenSizeReversed implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Comparator.comparing(Toy::getCost).reversed()
                .thenComparing(Comparator.comparing(Toy::getSize).reversed()).compare(o1, o2);
    }
}

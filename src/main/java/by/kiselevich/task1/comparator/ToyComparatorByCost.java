package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.toy.Toy;

import java.util.Comparator;

public class ToyComparatorByCost implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Comparator.comparing(Toy::getCost).compare(o1, o2);
    }
}

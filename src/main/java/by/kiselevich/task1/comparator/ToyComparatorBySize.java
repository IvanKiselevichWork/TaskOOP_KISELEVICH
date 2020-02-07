package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.toy.Toy;

import java.util.Comparator;

public class ToyComparatorBySize implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return Comparator.comparing(Toy::getSize).compare(o1, o2);
    }
}

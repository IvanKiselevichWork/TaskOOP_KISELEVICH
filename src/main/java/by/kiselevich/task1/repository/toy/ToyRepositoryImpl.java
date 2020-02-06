package by.kiselevich.task1.repository.toy;

import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.specification.Specification;

import java.util.*;

public class ToyRepositoryImpl implements ToyRepository {

    private List<Toy> toys = new ArrayList<>();

    @Override
    public void addAll(List<Toy> list) {
        toys.addAll(list);
    }

    @Override
    public List<Toy> getAll() {
        return new ArrayList<>(toys);
    }

    @Override
    public List<Toy> query(Specification<Toy> specification) {
        return specification.query(this);
    }
}

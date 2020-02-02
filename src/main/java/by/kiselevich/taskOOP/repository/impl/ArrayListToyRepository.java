package by.kiselevich.taskOOP.repository.impl;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.repository.ToyRepository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToyRepository implements ToyRepository {

    List<Toy> toys = new ArrayList<>();

    @Override
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    @Override
    public void addToys(List<Toy> toys) {
        this.toys.addAll(toys);
    }

    @Override
    public List<Toy> getAllToys() {
        return new ArrayList<>(toys);
    }

    @Override
    public List<Toy> getToysWithSizes(ToySize... toySizes) {
        return null;
    }
    //todo
}

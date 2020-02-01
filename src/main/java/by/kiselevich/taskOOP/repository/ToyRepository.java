package by.kiselevich.taskOOP.repository;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;

import java.util.List;

public interface ToyRepository {
    void addToy(Toy toy);
    void removeToy(Toy toy);
    List<Toy> getAllToys();
    List<Toy> getToysWithSizes(ToySize ... toySizes);
}

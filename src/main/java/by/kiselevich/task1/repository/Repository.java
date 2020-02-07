package by.kiselevich.task1.repository;

import by.kiselevich.task1.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void addAll(List<T> list);
    List<T> getAll();
    List<T> query(Specification<T> specification);
    void add(T t);
    void remove(T t);
    void update(T t);
}

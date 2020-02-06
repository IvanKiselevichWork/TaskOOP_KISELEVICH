package by.kiselevich.task1.specification;

import by.kiselevich.task1.repository.Repository;

import java.util.List;

public interface Specification<T> {
    List<T> query(Repository<T> repository);
}

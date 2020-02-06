package by.kiselevich.task1.repository.child;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class ChildRepositoryImpl implements ChildRepository {

    private List<Child> children = new ArrayList<>();

    @Override
    public void addAll(List<Child> list) {
        children.addAll(list);
    }

    @Override
    public List<Child> getAll() {
        return new ArrayList<>(children);
    }

    @Override
    public List<Child> query(Specification<Child> specification) {
        return specification.query(this);
    }
}

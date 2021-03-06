package by.kiselevich.task1.repository.child;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.specification.Specification;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChildRepositoryImpl implements ChildRepository {

    private Set<Child> children = new HashSet<>();

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

    @Override
    public void add(Child child) {
        children.add(child);
    }

    @Override
    public void remove(Child child) {
        children.remove(child);
    }

    @Override
    public void update(Child child) {
        if (children.remove(child)) {
            children.add(child);
        }
    }
}

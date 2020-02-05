package by.kiselevich.task1.repository.impl;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.repository.ChildRepository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListChildRepository implements ChildRepository {

    private List<Child> children = new ArrayList<>();

    @Override
    public void addChildren(List<Child> children) {
        this.children.addAll(children);
    }

    @Override
    public List<Child> getAllChildren() {
        return new ArrayList<>(children);
    }
}

package by.kiselevich.taskOOP.repository.impl;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.repository.ChildRepository;

import java.util.ArrayList;
import java.util.List;

public class ArrayListChildRepository implements ChildRepository {

    private final List<Child> children = new ArrayList<>();

    @Override
    public void addChild(Child child) {
        children.add(child);
    }

    @Override
    public void removeChild(Child child) {
        children.remove(child);
    }

    @Override
    public List<Child> getAllChildren() {
        return new ArrayList<>(children);
    }

    @Override
    public Child getChild() {
        return children.remove(children.size() - 1);
    }
}

package by.kiselevich.task1.repository;

import by.kiselevich.task1.entity.child.Child;

import java.util.List;

public interface ChildRepository {
    void addChildren(List<Child> children);
    List<Child> getAllChildren();
}

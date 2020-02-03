package by.kiselevich.taskOOP.repository;

import by.kiselevich.taskOOP.entity.child.Child;

import java.util.List;

public interface ChildRepository {
    void addChildren(List<Child> children);
    List<Child> getAllChildren();
    Child getChild();
}

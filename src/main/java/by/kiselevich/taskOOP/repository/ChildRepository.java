package by.kiselevich.taskOOP.repository;

import by.kiselevich.taskOOP.entity.child.Child;

import java.util.List;

public interface ChildRepository {
    void addChild(Child child);
    void removeChild(Child child);
    List<Child> getAllChildren();
    Child getChild();
}

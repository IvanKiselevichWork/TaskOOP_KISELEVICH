package by.kiselevich.taskOOP.repository;

import by.kiselevich.taskOOP.entity.child.Child;

public interface ChildRepository {
    void addChild(Child child);
    void removeChild(Child child);
    void getAllChildren();
}

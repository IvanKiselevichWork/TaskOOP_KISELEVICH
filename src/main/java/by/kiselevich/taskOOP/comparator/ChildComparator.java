package by.kiselevich.taskOOP.comparator;

import by.kiselevich.taskOOP.entity.child.Child;

import java.util.Comparator;

public class ChildComparator implements Comparator<Child> {
    @Override
    public int compare(Child o1, Child o2) {
        Comparator<Child> comparator = Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getLastName)
                .thenComparing(Child::getFirstName);
        return comparator.compare(o1, o2);
    }
}

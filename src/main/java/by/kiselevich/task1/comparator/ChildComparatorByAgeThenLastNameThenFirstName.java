package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.child.Child;

import java.util.Comparator;

public class ChildComparatorByAgeThenLastNameThenFirstName implements Comparator<Child> {
    @Override
    public int compare(Child o1, Child o2) {
        Comparator<Child> comparator = Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getLastName)
                .thenComparing(Child::getFirstName);
        return comparator.compare(o1, o2);
    }
}

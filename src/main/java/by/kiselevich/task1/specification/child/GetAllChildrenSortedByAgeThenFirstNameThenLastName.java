package by.kiselevich.task1.specification.child;

import by.kiselevich.task1.comparator.ChildComparatorByAgeThenLastNameThenFirstName;
import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.repository.Repository;

import java.util.List;

public class GetAllChildrenSortedByAgeThenFirstNameThenLastName implements ChildSpecification {

    @Override
    public List<Child> query(Repository<Child> repository) {
        List<Child> children = repository.getAll();
        children.sort(new ChildComparatorByAgeThenLastNameThenFirstName());
        return children;
    }
}

package by.kiselevich.task1.specification.child;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class GetChildById implements ChildSpecification {

    private int id;

    public GetChildById(int id) {
        this.id = id;
    }

    @Override
    public List<Child> query(Repository<Child> repository) {
        List<Child> result = new ArrayList<>();
        List<Child> children = repository.getAll();
        for (Child child : children) {
            if (child.getId() == id) {
                result.add(child);
                break;
            }
        }
        return result;
    }
}

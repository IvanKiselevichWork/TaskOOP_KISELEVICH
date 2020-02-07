package by.kiselevich.task1.specification.child;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.repository.child.ChildRepository;
import by.kiselevich.task1.repository.child.ChildRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GetChildByIdTest extends Assert {

    @Test
    public void getChildByIdTest1() {
        Child child1 = new Child();
        child1.setAge(5);
        Child child2 = new Child();
        child2.setAge(10);
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> childList = childRepository.query(new GetChildById(child1.getId()));
        assertEquals(1, childList.size());
        assertEquals(child1, childList.get(0));
    }

    @Test
    public void getChildByIdTest2() {
        Child child1 = new Child();
        child1.setAge(5);
        Child child2 = new Child();
        child2.setAge(10);
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> childList = childRepository.query(new GetChildById(-5));
        assertEquals(0, childList.size());
    }
}

package by.kiselevich.task1.specification.child;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.repository.child.ChildRepository;
import by.kiselevich.task1.repository.child.ChildRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GetAllChildrenSortedByAgeThenFirstNameThenLastNameTest extends Assert {

    @Test
    public void compareChildrenByAgeTest() {
        Child child1 = new Child();
        child1.setAge(5);
        Child child2 = new Child();
        child2.setAge(10);
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> childList = childRepository.query(new GetAllChildrenSortedByAgeThenFirstNameThenLastName());
        assertEquals(childList.get(0), child1);
        assertEquals(childList.get(1), child2);
    }

    @Test
    public void compareChildrenByLastNameTest() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        Child child2 = new Child();
        child2.setLastName("Zdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> childList = childRepository.query(new GetAllChildrenSortedByAgeThenFirstNameThenLastName());
        assertEquals(childList.get(0), child1);
        assertEquals(childList.get(1), child2);
    }

    @Test
    public void compareChildrenByFirstNameTest() {
        Child child1 = new Child();
        child1.setFirstName("Gdfsdf");
        child1.setLastName("Qwerty");
        Child child2 = new Child();
        child2.setFirstName("Zdfsdf");
        child2.setLastName("Qwerty");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> childList = childRepository.query(new GetAllChildrenSortedByAgeThenFirstNameThenLastName());
        assertEquals(childList.get(0), child1);
        assertEquals(childList.get(1), child2);
    }
}

package by.kiselevich.task1.comparator;

import by.kiselevich.task1.entity.child.Child;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ChildComparatorByAgeThenLastNameThenFirstNameTest extends Assert {

    @Test
    public void compareChildrenByAgeTest() {
        Comparator<Child> comparator = new ChildComparatorByAgeThenLastNameThenFirstName();
        Child child1 = new Child();
        child1.setAge(5);
        Child child2 = new Child();
        child2.setAge(10);
        assertTrue(comparator.compare(child1, child2) < 0);
        assertTrue(comparator.compare(child2, child1) > 0);
    }

    @Test
    public void compareChildrenByLastNameTest() {
        Comparator<Child> comparator = new ChildComparatorByAgeThenLastNameThenFirstName();
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        Child child2 = new Child();
        child2.setLastName("Zdfsdf");
        assertTrue(comparator.compare(child1, child2) < 0);
        assertTrue(comparator.compare(child2, child1) > 0);
    }

    @Test
    public void compareChildrenByFirstNameTest() {
        Comparator<Child> comparator = new ChildComparatorByAgeThenLastNameThenFirstName();
        Child child1 = new Child();
        child1.setFirstName("Gdfsdf");
        child1.setLastName("Qwerty");
        Child child2 = new Child();
        child2.setFirstName("Zdfsdf");
        child2.setLastName("Qwerty");
        assertTrue(comparator.compare(child1, child2) < 0);
        assertTrue(comparator.compare(child2, child1) > 0);
    }
}

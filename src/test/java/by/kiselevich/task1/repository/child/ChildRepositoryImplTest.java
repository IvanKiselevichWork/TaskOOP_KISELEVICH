package by.kiselevich.task1.repository.child;

import by.kiselevich.task1.entity.child.Child;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ChildRepositoryImplTest extends Assert {

    @Test
    public void addAllGetAllTest() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        Child child2 = new Child();
        child2.setLastName("Zdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.addAll(Arrays.asList(child2, child1));
        List<Child> children = childRepository.getAll();
        assertEquals(2, children.size());
        assertTrue(children.contains(child1));
        assertTrue(children.contains(child2));
    }

    @Test
    public void addTest1() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.add(child1);
        List<Child> children = childRepository.getAll();
        assertEquals(1, children.size());
        assertTrue(children.contains(child1));
    }

    @Test
    public void addTest2() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.add(child1);
        childRepository.add(child1);
        List<Child> children = childRepository.getAll();
        assertEquals(1, children.size());
        assertTrue(children.contains(child1));
    }

    @Test
    public void removeTest1() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        Child child2 = new Child();
        child2.setLastName("Zdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.add(child1);
        childRepository.add(child2);
        childRepository.remove(child1);
        List<Child> children = childRepository.getAll();
        assertEquals(1, children.size());
        assertTrue(children.contains(child2));
    }

    @Test
    public void removeTest2() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        Child child2 = new Child();
        child2.setLastName("Zdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.add(child1);
        childRepository.add(child2);
        Child child3 = new Child();
        child2.setLastName("Zdfsdf");
        childRepository.remove(child3);
        List<Child> children = childRepository.getAll();
        assertEquals(2, children.size());
        assertTrue(children.contains(child1));
        assertTrue(children.contains(child2));
    }

    @Test
    public void updateTest1() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.add(child1);
        child1.setLastName("Qwerty");
        childRepository.update(child1);
        List<Child> children = childRepository.getAll();
        assertEquals(1, children.size());
        assertTrue(children.contains(child1));
    }

    @Test
    public void updateTest2() {
        Child child1 = new Child();
        child1.setLastName("Gdfsdf");
        ChildRepository childRepository = new ChildRepositoryImpl();
        childRepository.update(child1);
        List<Child> children = childRepository.getAll();
        assertEquals(0, children.size());
    }
}

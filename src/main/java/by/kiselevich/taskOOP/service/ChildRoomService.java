package by.kiselevich.taskOOP.service;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildReader;
import by.kiselevich.taskOOP.reader.ToyReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.repository.ToyRepository;

public class ChildRoomService {

    private final ChildRepository childRepository;
    private final ToyRepository toyRepository;

    private ChildRoomService() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        toyRepository = ToyRepositoryFactory.getInstance().getToyRepository();
        initToys();
        initChildren();
    }

    private static class ChildRoomServiceHolder {
        public static final ChildRoomService instance = new ChildRoomService();
    }

    /**
     *
     * @return
     */
    public static ChildRoomService getInstance() {
        return ChildRoomServiceHolder.instance;
    }

    private void initChildren() {
        childRepository.addChildren(ChildReader.getInstance().readChildren());
    }

    private void initToys() {
        toyRepository.addToys(ToyReader.getInstance().readToys());
    }

    public void serveChild(Child child) {
        if (child.receiveToys(toyRepository)) {
            //todo thread
        }
    }

}

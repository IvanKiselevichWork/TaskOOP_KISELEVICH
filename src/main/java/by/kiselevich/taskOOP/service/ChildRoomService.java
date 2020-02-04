package by.kiselevich.taskOOP.service;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.reader.ToyReader;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ChildRoomService {

    private static final Logger logger = LogManager.getLogger(ChildRoomService.class);

    private final ToyRepository toyRepository;

    private ChildRoomService() {
        toyRepository = ToyRepositoryFactory.getInstance().getToyRepository();
        initToys();
    }

    private static class ChildRoomServiceHolder {
        public static final ChildRoomService instance = new ChildRoomService();
    }

    public static ChildRoomService getInstance() {
        return ChildRoomServiceHolder.instance;
    }

    private void initToys() {
        toyRepository.addToys(ToyReader.getInstance().readToys());
    }

    public void serveChild(Child child) {
        //todo
    }

}

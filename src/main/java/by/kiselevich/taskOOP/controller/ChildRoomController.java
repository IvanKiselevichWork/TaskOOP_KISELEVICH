package by.kiselevich.taskOOP.controller;

import by.kiselevich.taskOOP.comparator.ChildComparator;
import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildFileReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.service.ChildRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ChildRoomController {

    private static final String CHILDREN_FILEPATH = "children.txt";
    private static final Logger LOGGER = LogManager.getLogger(ChildRoomController.class);

    private ChildRepository childRepository;
    private ChildRoomService childRoomService;
    private ChildComparator childComparator;

    public ChildRoomController() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        childRoomService = ChildRoomService.getInstance();
        initChildren();
        childComparator = new ChildComparator();
    }

    private void initChildren() {
        childRepository.addChildren(new ChildFileReader(CHILDREN_FILEPATH).readChildrenFromFile());
        LOGGER.info("Children initiated");
    }

    public void serveChildren() {
        List<Child> children = childRepository.getAllChildren();
        children.sort(childComparator);
        for (Child child : children) {
            childRoomService.serveChild(child);
        }
    }
}

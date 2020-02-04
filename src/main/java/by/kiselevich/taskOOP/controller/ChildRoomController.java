package by.kiselevich.taskOOP.controller;

import by.kiselevich.taskOOP.comparator.ChildComparator;
import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildFileReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.service.ChildRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

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
        Optional<URL> optionalURL = Optional.ofNullable(
                this.getClass().getClassLoader().getResource(CHILDREN_FILEPATH));
        if (optionalURL.isPresent()) {
            try {
                String path = Paths.get(optionalURL.get().toURI()).toString();
                childRepository.addChildren(new ChildFileReader(path).readChildrenFromFile());
                LOGGER.info("Children initiated");
            } catch (URISyntaxException e) {
                LOGGER.warn(e);
            }
        } else {
            LOGGER.warn("Children file not found: " + CHILDREN_FILEPATH);
        }
    }

    public void serveChildren() {
        List<Child> children = childRepository.getAllChildren();
        children.sort(childComparator);
        for (Child child : children) {
            LOGGER.info("child " + child + "start serving, age = " + child.getAge());
            childRoomService.serveChild(child);
        }
    }
}

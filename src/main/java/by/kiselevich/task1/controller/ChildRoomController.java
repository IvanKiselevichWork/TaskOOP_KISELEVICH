package by.kiselevich.task1.controller;

import by.kiselevich.task1.comparator.ChildComparatorByAgeThenLastNameThenFirstName;
import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.factory.ChildRepositoryFactory;
import by.kiselevich.task1.reader.ChildFileReader;
import by.kiselevich.task1.repository.child.ChildRepository;
import by.kiselevich.task1.service.ChildRoomService;
import by.kiselevich.task1.specification.child.GetAllChildrenSortedByAgeThenFirstNameThenLastName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public ChildRoomController() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        childRoomService = ChildRoomService.getInstance();
        initChildren();
    }

    private void initChildren() {
        Optional<URL> optionalURL = Optional.ofNullable(
                this.getClass().getClassLoader().getResource(CHILDREN_FILEPATH));
        if (optionalURL.isPresent()) {
            try {
                String path = Paths.get(optionalURL.get().toURI()).toString();
                childRepository.addAll(new ChildFileReader(path).readChildrenFromFile());
                LOGGER.info("Children initiated");
            } catch (URISyntaxException e) {
                LOGGER.warn(e);
            }
        } else {
            LOGGER.warn("Children file not found: " + CHILDREN_FILEPATH);
        }
    }

    public void serveChildren() {
        List<Child> children = childRepository.query(new GetAllChildrenSortedByAgeThenFirstNameThenLastName());
        for (Child child : children) {
            LOGGER.info("child " + child + "start serving, age = " + child.getAge());
            childRoomService.serveChild(child);
        }
    }
}

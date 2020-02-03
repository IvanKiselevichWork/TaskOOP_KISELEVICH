package by.kiselevich.taskOOP.controller;

import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.service.ChildRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildRoomController {

    private static final Logger logger = LogManager.getLogger(ChildRoomController.class);

    private ChildRepository childRepository;
    private ChildRoomService childRoomService;

    public ChildRoomController() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        childRoomService = ChildRoomService.getInstance();
        initChildren();
    }

    private void initChildren() {
        childRepository.addChildren(ChildReader.getInstance().readChildren());
    }


    public void serveChildren() {
        logger.info("Start controller");
        while (!childRepository.getAllChildren().isEmpty()) {
            logger.info("controller work");
            childRoomService.serveChild(childRepository.getChild());
        }
        logger.info("Wait for children");
        childRoomService.waitForChildren();
        logger.info("End controller");
    }
}

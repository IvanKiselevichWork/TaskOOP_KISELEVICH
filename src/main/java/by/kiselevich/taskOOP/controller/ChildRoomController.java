package by.kiselevich.taskOOP.controller;

import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildFileReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.service.ChildRoomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildRoomController {

    private static final Logger LOGGER = LogManager.getLogger(ChildRoomController.class);

    private final ChildRepository childRepository;
    private final ChildRoomService childRoomService;

    public ChildRoomController() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        childRoomService = ChildRoomService.getInstance();
        initChildren();
    }

    private void initChildren() {
        childRepository.addChildren(ChildFileReader.getInstance().readChildren());
    }


    public void serveChildren() {
        //todo
    }
}

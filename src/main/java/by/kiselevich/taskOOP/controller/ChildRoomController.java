package by.kiselevich.taskOOP.controller;

import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.service.ChildRoomService;

public class ChildRoomController {
    private ChildRepository childRepository;
    private ChildRoomService childRoomService;

    public ChildRoomController() {
        childRepository = ChildRepositoryFactory.getInstance().getChildRepository();
        childRoomService = ChildRoomService.getInstance();
    }

    public void serveChildren() {
        while (!childRepository.getAllChildren().isEmpty()) {
            childRoomService.serveChild(childRepository.getChild());
        }
    }
}

package by.kiselevich.taskOOP.service;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.factory.ChildRepositoryFactory;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildReader;
import by.kiselevich.taskOOP.reader.ToyReader;
import by.kiselevich.taskOOP.repository.ChildRepository;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ChildRoomService {

    private static final Logger logger = LogManager.getLogger(ChildRoomService.class);

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

    /**
     *
     * @param child
     */
    public void serveChild(Child child) {
        synchronized (toyRepository) {
            if (child.receiveToys(toyRepository)) {
                logger.info("Child " + child + " start");
                try {
                    List<Toy> returnedToys = child.call();
                    toyRepository.addToys(returnedToys);
                    logger.info("Child " + child + " served");
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

}

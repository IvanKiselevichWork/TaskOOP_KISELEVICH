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

import java.util.ArrayList;
import java.util.List;

public class ChildRoomService {

    private static final Logger logger = LogManager.getLogger(ChildRoomService.class);

    private final ToyRepository toyRepository;
    private final List<Thread> threads;

    private ChildRoomService() {
        toyRepository = ToyRepositoryFactory.getInstance().getToyRepository();
        initToys();
        threads = new ArrayList<>();
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


    private void initToys() {
        toyRepository.addToys(ToyReader.getInstance().readToys());
    }

    /**
     *
     * @param child
     */
    public void serveChild(Child child) {
        if (child.receiveToys(toyRepository)) {
            logger.info("Child " + child + " start");
            try {
                Thread thread = new Thread(child);
                threads.add(thread);
                thread.start();
            } catch (Exception e) {
                logger.error(e);
            }
        } else {
            logger.info("Child " + child + " cant receive toys, skip");
        }
    }

    public void waitForChildren() {
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }

}

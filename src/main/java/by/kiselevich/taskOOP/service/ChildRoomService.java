package by.kiselevich.taskOOP.service;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.reader.ToyFileReader;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class ChildRoomService {

    private final static String CHILDREN_FILEPATH = "children.txt";
    private static final Logger LOGGER = LogManager.getLogger(ChildRoomService.class);

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
        toyRepository.addToys(new ToyFileReader(CHILDREN_FILEPATH).readToys());
        LOGGER.info("Toys initiated");
    }

    public void serveChild(Child child) {
        BigDecimal budgetPerHour = child.getBudget().divide(BigDecimal.valueOf(child.getHours()), BigDecimal.ROUND_DOWN);
        List<Toy> toys = toyRepository.getToysForSummaryCostWithSizes(budgetPerHour, ToySize.BIG, ToySize.MEDIUM);
        if (!toys.isEmpty()) {
            BigDecimal totalCostOfToys = BigDecimal.valueOf(0);
            for (Toy toy : toys) {
                totalCostOfToys = totalCostOfToys.add(toy.getCost());
            }
            totalCostOfToys = totalCostOfToys.multiply(BigDecimal.valueOf(child.getHours()));
            child.setBudget(child.getBudget().subtract(totalCostOfToys));
            child.playWithToys(toys);
        }
    }
}

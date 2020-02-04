package by.kiselevich.taskOOP.service;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.reader.ChildFileReader;
import by.kiselevich.taskOOP.reader.ToyFileReader;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class ChildRoomService {

    private final static String TOYS_FILEPATH = "toys.txt";
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
        Optional<URL> optionalURL = Optional.ofNullable(
                this.getClass().getClassLoader().getResource(TOYS_FILEPATH));
        if (optionalURL.isPresent()) {
            try {
                String path =  Paths.get(optionalURL.get().toURI()).toString();
                toyRepository.addToys(new ToyFileReader(path).readToys());
                LOGGER.info("Toys initiated");
            } catch (URISyntaxException e) {
                LOGGER.warn(e);
            }
        } else {
            LOGGER.warn("Toys file not found: " + TOYS_FILEPATH);
        }
    }

    public void serveChild(Child child) {
        BigDecimal budgetPerHour = child.getBudget().divide(BigDecimal.valueOf(child.getHours()), BigDecimal.ROUND_DOWN);
        ToySize[] toysSizes = getToysSizesByChildAge(child.getAge());
        List<Toy> toys = toyRepository.getToysForSummaryCostWithSizes(budgetPerHour, toysSizes);
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

    private ToySize[] getToysSizesByChildAge(int age) {
        if (age >= 2 && age < 7) {
            return new ToySize[]{ToySize.BIG};
        } else if (age >= 7 && age < 12) {
            return new ToySize[]{ToySize.BIG, ToySize.MEDIUM};
        } else {
            return new ToySize[]{ToySize.BIG, ToySize.MEDIUM, ToySize.SMALL};
        }
    }
}

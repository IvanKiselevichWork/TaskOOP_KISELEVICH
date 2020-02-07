package by.kiselevich.task1.service;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;
import by.kiselevich.task1.factory.ToyRepositoryFactory;
import by.kiselevich.task1.reader.ToyFileReader;
import by.kiselevich.task1.repository.toy.ToyRepository;
import by.kiselevich.task1.specification.toy.GetToysBySizes;
import by.kiselevich.task1.specification.toy.GetToysByTypes;
import by.kiselevich.task1.specification.toy.GetToysForSummaryCostWithSizes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class ChildRoomService {

    private static final String TOYS_FILEPATH = "toys.txt";
    private static final Logger LOGGER = LogManager.getLogger(ChildRoomService.class);

    private static final int YOUNG_CHILD_MIN_AGE = 2;
    private static final int YOUNG_CHILD_MAX_AGE = 6;
    private static final int MIDDLE_CHILD_MIN_AGE = 7;
    private static final int MIDDLE_CHILD_MAX_AGE = 11;
    private static final int OLD_CHILD_MIN_AGE = 12;
    private static final int OLD_CHILD_MAX_AGE = 15;

    private ToyRepository toyRepository;

    private ChildRoomService() {
        toyRepository = ToyRepositoryFactory.getInstance().getToyRepository();
        initToys();
    }

    private static class ChildRoomServiceHolder {
        public static final ChildRoomService INSTANCE = new ChildRoomService();
    }

    public static ChildRoomService getInstance() {
        return ChildRoomServiceHolder.INSTANCE;
    }

    private void initToys() {
        Optional<URL> optionalURL = Optional.ofNullable(
                this.getClass().getClassLoader().getResource(TOYS_FILEPATH));
        if (optionalURL.isPresent()) {
            try {
                String path =  Paths.get(optionalURL.get().toURI()).toString();
                toyRepository.addAll(new ToyFileReader(path).readToys());
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
        List<Toy> toys = toyRepository.query(new GetToysForSummaryCostWithSizes(budgetPerHour, toysSizes));
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

    public List<Toy> getToyByType(ToyType ... toyTypes) {
        return toyRepository.query(new GetToysByTypes(toyTypes));
    }

    public List<Toy> getToyBySize(ToySize ... toySizes) {
        return toyRepository.query(new GetToysBySizes(toySizes));
    }

    private ToySize[] getToysSizesByChildAge(int age) {
        if (age >= YOUNG_CHILD_MIN_AGE && age <= YOUNG_CHILD_MAX_AGE) {
            return new ToySize[]{ToySize.BIG};
        } else if (age >= MIDDLE_CHILD_MIN_AGE && age <= MIDDLE_CHILD_MAX_AGE) {
            return new ToySize[]{ToySize.BIG, ToySize.MEDIUM};
        } else if (age >= OLD_CHILD_MIN_AGE && age <= OLD_CHILD_MAX_AGE) {
            return new ToySize[]{ToySize.BIG, ToySize.MEDIUM, ToySize.SMALL};
        } else {
            return new ToySize[]{};
        }
    }
}

package by.kiselevich.taskOOP.reader;

import by.kiselevich.taskOOP.utils.Utils;
import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.entity.toy.ToyType;
import by.kiselevich.taskOOP.factory.ToyFactory;
import by.kiselevich.taskOOP.validator.ToyValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToyReader {

    private static final String TOYS_RESOURCES_FILE = "toys.txt";
    private static final String DELIMITER = ";";
    private static final URL TOYS_FILEPATH;
    private static final boolean isReadingPossibly;
    private static final Logger logger = LogManager.getLogger(ToyReader.class);

    private ToyValidator validator;
    private ToyFactory toyFactory;

    static {
        Optional<URL> optional = Optional.ofNullable(
                ToyReader.class.getClassLoader().getResource(TOYS_RESOURCES_FILE));
        if (optional.isPresent()) {
            TOYS_FILEPATH = optional.get();
            isReadingPossibly = true;
        } else {
            logger.warn("No toys file! Toy reader always return empty list!");
            TOYS_FILEPATH = null;
            isReadingPossibly = false;
        }
    }

    private ToyReader() {
        validator = new ToyValidator();
        toyFactory = ToyFactory.getInstance();
    }

    private static final class ToyReaderHolder {
        private static final ToyReader instance = new ToyReader();
    }

    public static ToyReader getInstance() {
        return ToyReaderHolder.instance;
    }

    public List<Toy> readToys() {
        List<Toy> toys = new ArrayList<>();
        if(!isReadingPossibly) {
            logger.info("ToyReader return empty list");
            return toys;
        }
        try {
            List<String> toysStrList = Files.readAllLines(Paths.get(TOYS_FILEPATH.toURI()));
            for (String toysStr : toysStrList) {
                toys.addAll(parseToysFromString(toysStr));
            }
        } catch (IOException | URISyntaxException e) {
            logger.error(e);
        }
        return toys;
    }

    private List<Toy> parseToysFromString(String string) {
        List<Toy> toys = new ArrayList<>();
        try {
            String[] toyArray = string.split(DELIMITER);
            if (toyArray.length == 4) {
                ToyType toyType = ToyType.valueOf(toyArray[0]);
                ToySize toySize = ToySize.valueOf(toyArray[1]);
                BigDecimal cost;
                if(Utils.isStringParsableToBigDecimal(toyArray[2])) {
                    cost = Utils.parseStringToBigDecimal(toyArray[2]);
                } else {
                    logger.warn("Cannot parse toy cost from string");
                    return toys;
                }
                int count;
                if(Utils.isStringParsableToInt(toyArray[3])) {
                    count = Utils.parseStringToInt(toyArray[3]);
                } else {
                    logger.warn("Cannot parse toys count from string");
                    return toys;
                }
                if (validator.checkToyType(toyType)
                        && validator.checkToySize(toySize)
                        && validator.checkCost(cost)
                        && count > 0) {
                    return toyFactory.getToys(toyType, toySize, cost, count);
                } else {
                    logger.warn("Toys params not pass validation");
                }
            } else {
                logger.warn("Toys have wrong params count");
            }
        } catch (IllegalArgumentException e) {
            logger.error(e);
        }
        return toys;
    }

}

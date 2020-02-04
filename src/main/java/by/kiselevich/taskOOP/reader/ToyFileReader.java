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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToyFileReader {

    private static final Logger LOGGER = LogManager.getLogger(ToyFileReader.class);

    private ToyValidator validator;
    private ToyFactory toyFactory;
    private String toyFilepath;

    public ToyFileReader(String toyFilepath) {
        validator = new ToyValidator();
        toyFactory = ToyFactory.getInstance();
        this.toyFilepath = toyFilepath;
    }

    public List<Toy> readToys() {
        List<Toy> toys = new ArrayList<>();

        try {
            List<String> toysStrList = Files.readAllLines(Paths.get(toyFilepath));
            for (String toysStr : toysStrList) {
                toys.addAll(parseToysFromString(toysStr));
            }
        } catch (IOException | URISyntaxException e) {
            LOGGER.error(e);
        }
        return toys;
    }


}

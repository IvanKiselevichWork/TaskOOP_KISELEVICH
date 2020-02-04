package by.kiselevich.taskOOP.reader;

import by.kiselevich.taskOOP.exception.ToyParseException;
import by.kiselevich.taskOOP.parser.ToyParser;
import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.factory.ToyFactory;
import by.kiselevich.taskOOP.validator.ToyValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToyFileReader {

    private static final Logger LOGGER = LogManager.getLogger(ToyFileReader.class);

    private String toyFilepath;
    private ToyParser toyParser;

    public ToyFileReader(String toyFilepath) {
        this.toyFilepath = toyFilepath;
        toyParser = new ToyParser();
    }

    public List<Toy> readToys() {
        List<Toy> toys = new ArrayList<>();

        try {
            List<String> toysStrList = Files.readAllLines(Paths.get(toyFilepath));
            for (String toysStr : toysStrList) {
                try {
                    toys.addAll(toyParser.parseToysFromString(toysStr));
                } catch (ToyParseException e) {
                    LOGGER.warn(e);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return toys;
    }


}

package by.kiselevich.task1.reader;

import by.kiselevich.task1.exception.ToyParseException;
import by.kiselevich.task1.parser.ToyParser;
import by.kiselevich.task1.entity.toy.Toy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public void setToyFilepath(String toyFilepath) {
        this.toyFilepath = toyFilepath;
    }

    public List<Toy> readToys() {
        List<Toy> toys = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(toyFilepath))) {
            String toysStr;
            while ((toysStr = br.readLine()) != null) {
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

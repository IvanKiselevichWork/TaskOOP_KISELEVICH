package by.kiselevich.task1.reader;

import by.kiselevich.task1.exception.ChildParseException;
import by.kiselevich.task1.parser.ChildParser;
import by.kiselevich.task1.entity.child.Child;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChildFileReader {

    private static final Logger LOGGER = LogManager.getLogger(ChildFileReader.class);

    private ChildParser childParser;
    private String childrenFilepath;

    public ChildFileReader(String childrenFilepath) {
        childParser = new ChildParser();
        this.childrenFilepath = childrenFilepath;
    }

    public void setChildrenFilepath(String childrenFilepath) {
        this.childrenFilepath = childrenFilepath;
    }

    public List<Child> readChildrenFromFile() {
        List<Child> children = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(childrenFilepath))) {
            String childStr;
            while ((childStr = br.readLine()) != null) {
                try {
                    children.add(childParser.parseChildFromString(childStr));
                } catch (ChildParseException e) {
                    LOGGER.warn(e);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return children;
    }
}

package by.kiselevich.taskOOP.reader;

import by.kiselevich.taskOOP.exception.ChildParseException;
import by.kiselevich.taskOOP.parser.ChildParser;
import by.kiselevich.taskOOP.entity.child.Child;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        try {
            List<String> childrenStrList = Files.readAllLines(Paths.get(childrenFilepath));
            for (String childStr : childrenStrList) {
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

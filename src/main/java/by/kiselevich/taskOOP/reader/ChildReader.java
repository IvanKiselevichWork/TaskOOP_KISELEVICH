package by.kiselevich.taskOOP.reader;

import by.kiselevich.taskOOP.utils.Utils;
import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.validator.ChildValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChildReader {

    private static final String CHILDREN_RESOURCES_FILE = "children.txt";
    private static final String DELIMITER = ";";
    private static final String CHILDREN_FILEPATH;
    private static final boolean isReadingPossibly;
    private static final Logger logger = LogManager.getLogger(ChildReader.class);

    private ChildValidator validator;

    static {
        Optional<URL> optional = Optional.ofNullable(
                ChildReader.class.getClassLoader().getResource(CHILDREN_RESOURCES_FILE));
        if (optional.isPresent()) {
            CHILDREN_FILEPATH = optional.get().toString();
            isReadingPossibly = true;
        } else {
            logger.warn("No children file! Child reader always return empty list!");
            CHILDREN_FILEPATH = null;
            isReadingPossibly = false;
        }
    }

    private ChildReader() {
        validator = new ChildValidator();
    }

    private static final class ChildReaderHolder {
        private static final ChildReader instance = new ChildReader();
    }

    public static ChildReader getInstance() {
        return ChildReaderHolder.instance;
    }

    public List<Child> readChildren() {
        List<Child> children = new ArrayList<>();
        if (!isReadingPossibly) {
            logger.info("ChildReader return empty list!");
            return children;
        }
        try {
            List<String> childrenStrList = Files.readAllLines(Paths.get(CHILDREN_FILEPATH));
            for (String childStr : childrenStrList) {
                Optional<Child> optionalChild = Optional.ofNullable(
                        parseChildFromString(childStr));
                optionalChild.ifPresent(children::add);
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return children;
    }

    private Child parseChildFromString(String string) {
        String[] childArray = string.split(DELIMITER);
        if (childArray.length == 3) {
            String firstName = childArray[0];
            String lastName = childArray[1];
            int age;
            if (Utils.isStringParsableToInt(childArray[2])) {
                age = Utils.parseStringToInt(childArray[2]);
            } else {
                logger.warn("Cannot parse child age from string");
                return null;
            }
            if (validator.checkFirstName(firstName)
                    && validator.checkLastName(lastName)
                    && validator.checkAge(age)) {

                return new Child.Builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .age(age)
                        .build();
            } else {
                logger.warn("Child params not pass validation");
            }
        } else {
            logger.warn("Child have wrong params count");
        }
        return null;
    }

}

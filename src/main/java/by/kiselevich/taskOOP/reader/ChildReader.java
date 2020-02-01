package by.kiselevich.taskOOP.reader;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.validator.ChildValidator;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ChildReader {

    private static final String CHILDREN_RESOURCES_FILE = "children.txt";
    private static final String DELIMITER = ";";
    private static final String CHILDREN_FILEPATH;

    private ChildValidator validator;

    static {
        Optional<URL> optional = Optional.ofNullable(
                ChildReader.class.getClassLoader().getResource(CHILDREN_RESOURCES_FILE));
        if (optional.isPresent()) {
            CHILDREN_FILEPATH = optional.get().toString();
        } else {
            CHILDREN_FILEPATH = CHILDREN_RESOURCES_FILE;
        }
    }

    private ChildReader() {
        validator = new ChildValidator();
    }

    private static final class ChildReaderHolder {
        private static ChildReader instance = new ChildReader();
    }

    public static ChildReader getInstance() {
        return ChildReaderHolder.instance;
    }

    public List<Child> readChildren() {
        List<Child> children = new ArrayList<>();
        try {
            List<String> childrenStrList = Files.readAllLines(Paths.get(CHILDREN_FILEPATH));
            for (String childStr : childrenStrList) {
                String[] childArray = childStr.split(DELIMITER);
                if (childArray.length == 3) {
                    String firstName = childArray[0];
                    String lastName = childArray[1];
                    Scanner scanner = new Scanner(childArray[2]);
                    int age;
                    if (scanner.hasNextInt()) {
                        age = scanner.nextInt();
                    } else {
                        //todo write in logger
                        continue;
                    }
                    if (validator.checkFirstName(firstName)
                            && validator.checkLastName(lastName)
                            && validator.checkAge(age)) {

                        children.add(new Child.Builder()
                                .firstName(firstName)
                                .lastName(lastName)
                                .age(age)
                                .build());
                    }

                }
            }
        } catch (IOException e) {
            //todo logger
            e.printStackTrace();
        }
        return children;
    }

}

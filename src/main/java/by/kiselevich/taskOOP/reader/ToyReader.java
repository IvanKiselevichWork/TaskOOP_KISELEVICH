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

public class ToyReader {

    private static final String TOYS_RESOURCES_FILE = "toys.txt";
    private static final String DELIMITER = ";";
    private static final String TOYS_FILEPATH;

    private ToyValidator validator;

    static {
        Optional<URL> optional = Optional.ofNullable(
                ToyReader.class.getClassLoader().getResource(TOYS_RESOURCES_FILE));
        if (optional.isPresent()) {
            TOYS_FILEPATH = optional.get().toString();
        } else {
            TOYS_FILEPATH = TOYS_RESOURCES_FILE;
        }
    }

    private ToyReader() {
        validator = new ChildValidator();
    }

    private static final class ChildReaderHolder {
        private static ToyReader instance = new ToyReader();
    }

    public static ToyReader getInstance() {
        return ChildReaderHolder.instance;
    }

    public List<Child> readChildren() {
        List<Child> children = new ArrayList<>();
        try {
            List<String> childrenStrList = Files.readAllLines(Paths.get(TOYS_FILEPATH));
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

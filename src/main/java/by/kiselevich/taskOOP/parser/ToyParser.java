package by.kiselevich.taskOOP.parser;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.entity.toy.ToyType;
import by.kiselevich.taskOOP.exception.ToyParseException;
import by.kiselevich.taskOOP.factory.ToyFactory;
import by.kiselevich.taskOOP.validator.StringValidator;
import by.kiselevich.taskOOP.validator.ToyValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.kiselevich.taskOOP.exception.ToyExceptionMessages.*;

public class ToyParser {

    private static final Logger LOGGER = LogManager.getLogger(ToyParser.class);
    private static final String DELIMITER = ";";
    private final int DATA_ARRAY_SIZE = 4;
    private final int TYPE_INDEX = 0;
    private final int SIZE_INDEX = 1;
    private final int COST_INDEX = 2;
    private final int COUNT_INDEX = 3;

    private ToyValidator toyValidator;
    private StringParser stringParser;
    private StringValidator stringValidator;
    private ToyFactory toyFactory;

    public ToyParser() {
        toyValidator = new ToyValidator();
        stringParser = new StringParser();
        stringValidator = new StringValidator();
        toyFactory = ToyFactory.getInstance();
    }


    public List<Toy> parseToysFromString(String string) throws ToyParseException {
        List<Toy> toys = new ArrayList<>();

        String[] toyArray = string.split(DELIMITER);
        if (toyArray.length != DATA_ARRAY_SIZE) {
            throw new ToyParseException(INVALID_DATA_ARRAY_LENGTH.getMessage());
        }

        if (!stringValidator.isStringParsableToEnum(ToyType.class, toyArray[TYPE_INDEX])) {
            throw new ToyParseException(INVALID_TOY_TYPE.getMessage());
        }
        ToyType toyType = ToyType.valueOf(toyArray[TYPE_INDEX].toUpperCase());

        if (!stringValidator.isStringParsableToEnum(ToySize.class, toyArray[SIZE_INDEX])) {
            throw new ToyParseException(INVALID_TOY_SIZE.getMessage());
        }
        ToySize toySize = ToySize.valueOf(toyArray[SIZE_INDEX]);

        if(!stringValidator.isStringParsableToBigDecimal(toyArray[COST_INDEX])) {
            throw new ToyParseException(INVALID_TOY_COST.getMessage());
        }
        BigDecimal cost = stringParser.parseStringToBigDecimal(toyArray[COST_INDEX]);

        if(!stringValidator.isStringParsableToInt(toyArray[COUNT_INDEX])) {
            throw new ToyParseException(INVALID_TOY_COUNT.getMessage());
        }
        int count = stringParser.parseStringToInt(toyArray[3]);
        if (toyValidator.checkToyType(toyType)
                && toyValidator.checkToySize(toySize)
                && toyValidator.checkCost(cost)
                && count > 0) {
            LOGGER.info("Toy parsed");
            return toyFactory.createToys(toyType, toySize, cost, count);
        } else {
            throw new ToyParseException(TOY_NOT_PASS_VALIDATION.getMessage());
        }
    }
}

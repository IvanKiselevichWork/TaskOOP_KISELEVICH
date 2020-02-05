package by.kiselevich.task1.parser;

import by.kiselevich.task1.exception.ChildParseException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.InputMismatchException;

public class StringParserTest extends Assert {

    @Test
    public void parseStringToBigDecimalTestPositive() {
        String string = "234523";
        StringParser stringParser = new StringParser();
        BigDecimal bigDecimal = stringParser.parseStringToBigDecimal(string);
        assertEquals(bigDecimal, BigDecimal.valueOf(234523));
    }

    @Test(expected = InputMismatchException.class)
    public void parseStringToBigDecimalTestNegative() {
        String string = "asdfasdf";
        StringParser stringParser = new StringParser();
        stringParser.parseStringToBigDecimal(string);
    }

    @Test
    public void parseStringToIntTestPositive() {
        String string = "234523";
        StringParser stringParser = new StringParser();
        int num = stringParser.parseStringToInt(string);
        assertEquals(num, 234523);
    }

    @Test(expected = InputMismatchException.class)
    public void parseStringToIntTestNegative() {
        String string = "asdfasdf";
        StringParser stringParser = new StringParser();
        stringParser.parseStringToInt(string);
    }
}

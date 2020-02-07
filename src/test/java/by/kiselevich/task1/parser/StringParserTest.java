package by.kiselevich.task1.parser;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class StringParserTest extends Assert {

    @Test
    public void parseStringToBigDecimalTestPositive() {
        String string = "234523";
        StringParser stringParser = new StringParser();
        BigDecimal bigDecimal = stringParser.parseStringToBigDecimal(string);
        assertEquals(bigDecimal, BigDecimal.valueOf(234523));
    }

    @Test(expected = NumberFormatException.class)
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

    @Test(expected = NumberFormatException.class)
    public void parseStringToIntTestNegative() {
        String string = "asdfasdf";
        StringParser stringParser = new StringParser();
        stringParser.parseStringToInt(string);
    }
}

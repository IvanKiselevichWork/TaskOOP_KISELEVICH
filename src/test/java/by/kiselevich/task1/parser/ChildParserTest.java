package by.kiselevich.task1.parser;

import by.kiselevich.task1.exception.ChildParseException;
import org.junit.Assert;
import org.junit.Test;

public class ChildParserTest extends Assert {

    @Test
    public void parseChildTestPositive() throws ChildParseException {
        String string = "Ivan;Kiselevich;14;100;2";
        ChildParser childParser = new ChildParser();
        childParser.parseChildFromString(string);
    }

    @Test(expected = ChildParseException.class)
    public void parseChildTestNegative() throws ChildParseException {
        String string = "345;sfdsaf;345;";
        ChildParser childParser = new ChildParser();
        childParser.parseChildFromString(string);
    }
}

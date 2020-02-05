package by.kiselevich.task1.parser;

import by.kiselevich.task1.entity.child.Child;
import by.kiselevich.task1.exception.ChildParseException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChildParserTest extends Assert {

    @Test
    public void parseChildTestPositive() throws ChildParseException {
        String string = "Ivan;Kiselevich;14;100;2";
        ChildParser childParser = new ChildParser();
        Child child = childParser.parseChildFromString(string);
        assertEquals("Ivan", child.getFirstName());
        assertEquals("Kiselevich", child.getLastName());
        assertEquals(14, child.getAge());
        assertEquals(BigDecimal.valueOf(100), child.getBudget());
        assertEquals(2, child.getHours());
    }

    @Test(expected = ChildParseException.class)
    public void parseChildTestNegative() throws ChildParseException {
        String string = "345;sfdsaf;345;";
        ChildParser childParser = new ChildParser();
        childParser.parseChildFromString(string);
    }
}

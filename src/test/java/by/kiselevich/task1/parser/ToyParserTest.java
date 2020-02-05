package by.kiselevich.task1.parser;

import by.kiselevich.task1.entity.toy.Cube;
import by.kiselevich.task1.entity.toy.Toy;
import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.exception.ToyParseException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ToyParserTest extends Assert {

    private ToyParser toyParser = new ToyParser();

    @Test
    public void parseToysFromStringTestPositive() throws ToyParseException {
        String toyString = "CUBE;MEDIUM;12;3";
        List<Toy> toys = toyParser.parseToysFromString(toyString);
        assertEquals(3, toys.size());
        for (Toy toy : toys) {
            assertEquals(BigDecimal.valueOf(12),toy.getCost());
            assertEquals(ToySize.MEDIUM,toy.getSize());
            assertEquals(Cube.class,toy.getClass());
        }
    }

    @Test(expected = ToyParseException.class)
    public void parseToysFromStringTestNegative() throws ToyParseException {
        String toyString = "45545; 545 452 ;";
        toyParser.parseToysFromString(toyString);
    }
}

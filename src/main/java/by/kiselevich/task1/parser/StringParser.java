package by.kiselevich.task1.parser;

import java.math.BigDecimal;

public class StringParser {

    public BigDecimal parseStringToBigDecimal(String string) {
        return new BigDecimal(string);
    }

    public int parseStringToInt(String string) {
        return new Integer(string);
    }

}

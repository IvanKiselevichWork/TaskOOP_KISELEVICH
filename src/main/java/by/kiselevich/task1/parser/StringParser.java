package by.kiselevich.task1.parser;

import java.math.BigDecimal;
import java.util.Scanner;

public class StringParser {

    public BigDecimal parseStringToBigDecimal(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.nextBigDecimal();
    }

    public int parseStringToInt(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.nextInt();
    }

}

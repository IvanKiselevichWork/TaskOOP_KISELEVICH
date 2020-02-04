package by.kiselevich.taskOOP.parser;

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

    public <E extends Enum<E>> Enum<E> parseStringToEnum(Class<E> enumClass, String string) {

        for (Enum<E> enumVal: enumClass.getEnumConstants()) {
            if (enumVal.toString().toUpperCase().equals(string.toUpperCase())) {
                return enumVal;
            }
        }

        return null;
    }
}

package by.kiselevich.taskOOP.validator;

import java.util.Scanner;

public class StringValidator {

    public boolean isStringParsableToBigDecimal(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextBigDecimal();
    }

    public boolean isStringParsableToInt(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextInt();
    }
}

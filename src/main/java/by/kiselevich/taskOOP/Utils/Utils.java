package by.kiselevich.taskOOP.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Utils {
    public static boolean isStringParsableToBigDecimal(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextBigDecimal();
    }

    public static BigDecimal parseStringToBigDecimal(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.nextBigDecimal();
    }

    public static boolean isStringParsableToInt(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextInt();
    }

    public static int parseStringToInt(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.nextInt();
    }
}

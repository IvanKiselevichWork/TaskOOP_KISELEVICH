package by.kiselevich.taskOOP.validator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringValidator {

    public boolean isStringParsableToBigDecimal(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextBigDecimal();
    }

    public boolean isStringParsableToInt(String string) {
        Scanner scanner = new Scanner(string);
        return scanner.hasNextInt();
    }

    public <E extends Enum<E>> boolean isStringParsableToEnum(Class<E> enumClass, String string) {
        if(!enumClass.isEnum()) {
            return false;
        }

        Set<String> enumStringSet = new HashSet<>();
        for (Enum<E> enumVal: enumClass.getEnumConstants()) {
            enumStringSet.add(enumVal.toString().toUpperCase());
        }

        return enumStringSet.contains(string.toUpperCase());
    }
}

package by.kiselevich.taskOOP.validator;

import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.entity.toy.ToyType;

import java.math.BigDecimal;

public class ToyValidator {

    public boolean checkToyType(ToyType toyType) {
        return toyType != null;
    }

    public boolean checkToySize(ToySize toySize) {
        return toySize != null;
    }

    public boolean checkCost(BigDecimal cost) {
        return cost != null && cost.compareTo(BigDecimal.valueOf(0)) > 0;
    }
}

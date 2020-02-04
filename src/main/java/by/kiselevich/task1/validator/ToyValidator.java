package by.kiselevich.task1.validator;

import by.kiselevich.task1.entity.toy.ToySize;
import by.kiselevich.task1.entity.toy.ToyType;

import java.math.BigDecimal;

public class ToyValidator {

    public boolean isToyTypeNotNull(ToyType toyType) {
        return toyType != null;
    }

    public boolean isToySizeNotNull(ToySize toySize) {
        return toySize != null;
    }

    public boolean isCostNotNullAndPositive(BigDecimal cost) {
        return cost != null && cost.compareTo(BigDecimal.valueOf(0)) > 0;
    }
}

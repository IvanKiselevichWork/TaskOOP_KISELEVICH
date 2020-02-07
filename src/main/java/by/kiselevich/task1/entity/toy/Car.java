package by.kiselevich.task1.entity.toy;

import java.math.BigDecimal;

public class Car extends Toy {

    public Car(ToySize size, BigDecimal cost, ToyType toyType) {
        super(size, cost, toyType);
    }

    @Override
    public void play() {
        LOGGER.info("Ron-don-don!");
    }
}

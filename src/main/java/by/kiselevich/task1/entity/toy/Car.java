package by.kiselevich.task1.entity.toy;

import java.math.BigDecimal;

public class Car extends Toy {

    public Car(ToySize size, BigDecimal cost) {
        super(size, cost);
    }

    @Override
    public void play() {
        LOGGER.info("Ron-don-don!");
    }
}

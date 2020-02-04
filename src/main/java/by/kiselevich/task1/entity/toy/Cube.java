package by.kiselevich.task1.entity.toy;

import java.math.BigDecimal;

public class Cube extends Toy {

    public Cube(ToySize size, BigDecimal cost) {
        super(size, cost);
    }

    @Override
    public void play() {
        LOGGER.info("Cube");
    }
}

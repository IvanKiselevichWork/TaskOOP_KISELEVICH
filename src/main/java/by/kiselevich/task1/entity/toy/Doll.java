package by.kiselevich.task1.entity.toy;

import java.math.BigDecimal;

public class Doll extends Toy {

    public Doll(ToySize size, BigDecimal cost) {
        super(size, cost);
    }

    @Override
    public void play() {
        LOGGER.info("Mama!");
    }
}

package by.kiselevich.taskOOP.entity.toy;

import java.math.BigDecimal;

public class Ball extends Toy {

    public Ball(ToySize size, BigDecimal cost) {
        super(size, cost);
    }

    @Override
    public void play() {
        LOGGER.info("Bam");
    }
}

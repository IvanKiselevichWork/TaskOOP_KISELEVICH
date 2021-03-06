package by.kiselevich.task1.entity.toy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public abstract class Toy {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    private static int idCounter = 0;

    private static synchronized int getNextId() {
        return idCounter++;
    }

    protected int id;
    protected ToySize size;
    protected BigDecimal cost;
    protected ToyType toyType;

    public Toy() {
        this.id = getNextId();
    }

    public Toy(ToySize size, BigDecimal cost, ToyType toyType) {
        this.id = getNextId();
        this.size = size;
        this.cost = cost;
        this.toyType = toyType;
    }

    public int getId() {
        return id;
    }

    public ToySize getSize() {
        return size;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setSize(ToySize size) {
        this.size = size;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public void setToyType(ToyType toyType) {
        this.toyType = toyType;
    }

    public abstract void play();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        return id == toy.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "size=" + size +
                ", cost=" + cost +
                ", toyType=" + toyType +
                '}';
    }
}

package by.kiselevich.task1.entity.toy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public abstract class Toy {

    protected final Logger LOGGER = LogManager.getLogger(Toy.class);

    protected ToySize size;
    protected BigDecimal cost;
    protected ToyType toyType;

    public Toy() {

    }

    public Toy(ToySize size, BigDecimal cost, ToyType toyType) {
        this.size = size;
        this.cost = cost;
        this.toyType = toyType;
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

        if (size != toy.size) return false;
        if (cost != null ? !cost.equals(toy.cost) : toy.cost != null) return false;
        return toyType == toy.toyType;
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (toyType != null ? toyType.hashCode() : 0);
        return result;
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

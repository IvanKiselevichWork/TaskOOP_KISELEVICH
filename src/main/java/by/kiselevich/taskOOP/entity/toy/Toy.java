package by.kiselevich.taskOOP.entity.toy;

import java.math.BigDecimal;

public class Toy {
    private ToyType toyType;
    private ToySize size;
    private BigDecimal cost;

    public Toy(ToyType toyType, ToySize size, BigDecimal cost) {
        this.toyType = toyType;
        this.size = size;
        this.cost = cost;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public ToySize getSize() {
        return size;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (toyType != toy.toyType) return false;
        if (size != toy.size) return false;
        return cost.equals(toy.cost);
    }

    @Override
    public int hashCode() {
        int result = toyType.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + cost.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "toyType=" + toyType +
                ", size=" + size +
                ", cost=" + cost +
                '}';
    }
}

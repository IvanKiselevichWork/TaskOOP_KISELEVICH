package by.kiselevich.taskOOP.entity.child;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.factory.ToyRepositoryFactory;
import by.kiselevich.taskOOP.repository.ToyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public abstract class Child implements Runnable {

    private static final Logger logger = LogManager.getLogger(Child.class);

    private String firstName;
    private String lastName;

    protected BigDecimal budget;
    protected int hours;

    protected List<Toy> toys;

    public static class Builder {

        private String firstName;
        private String lastName;
        private Integer age;
        protected BigDecimal budget;
        protected Integer hours;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder budget(BigDecimal budget) {
            this.budget = budget;
            return this;
        }

        public Builder hours(Integer hours) {
            this.hours = hours;
            return this;
        }

        public Child build() {
            Child child;
            if (age >= 2 && age < 7) {
                child = new YoungerChild() {
                };
            } else if (age >= 7 && age < 12) {
                child = new MiddleChild();
            } else {
                child = new OlderChild();
            }
            child.firstName = firstName;
            child.lastName = lastName;
            child.budget = budget;
            child.hours = hours;
            return child;
        }

    }

    public abstract boolean receiveToys(ToyRepository toyRepository);

    @Override
    public void run() {
        try {
            Thread.sleep(hours * 1000);
            ToyRepositoryFactory.getInstance().getToyRepository().addToys(toys);
            toys = null;
            logger.info("Child " + this + " served");
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    protected void removeMoneyForToys() {
        BigDecimal sumToys = BigDecimal.valueOf(0);
        for (Toy toy : toys) {
            sumToys = sumToys.add(toy.getCost());
        }
        sumToys = sumToys.multiply(BigDecimal.valueOf(hours));
        budget = budget.subtract(sumToys);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (!firstName.equals(child.firstName)) return false;
        return lastName.equals(child.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

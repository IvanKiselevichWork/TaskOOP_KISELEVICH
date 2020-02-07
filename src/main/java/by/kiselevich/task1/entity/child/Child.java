package by.kiselevich.task1.entity.child;

import by.kiselevich.task1.entity.toy.Toy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class Child {

    private static final Logger LOGGER = LogManager.getLogger(Child.class);

    private static int idCounter = 0;

    private static synchronized int getNextId() {
        return idCounter++;
    }

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int hours;
    private BigDecimal budget;

    public static class Builder {

        private String firstName;
        private String lastName;
        private int age;
        protected BigDecimal budget;
        protected int hours;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder budget(BigDecimal budget) {
            this.budget = budget;
            return this;
        }

        public Builder hours(int hours) {
            this.hours = hours;
            return this;
        }

        public Child build() {
            Child child = new Child();
            child.firstName = firstName;
            child.lastName = lastName;
            child.age = age;
            child.budget = budget;
            child.hours = hours;
            return child;
        }

    }

    public Child() {
        this.id = getNextId();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        return id == child.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void playWithToys(List<Toy> toys) {
        for (int i = 0; i < hours; i++) {
            LOGGER.info("Child: " + this + " play " + (i + 1) + " hour");
            for (Toy toy : toys) {
                LOGGER.info("Child: " + this + " play with toy: " + toy + " " + toy.getClass().getSimpleName());
                toy.play();
            }
        }
    }
}

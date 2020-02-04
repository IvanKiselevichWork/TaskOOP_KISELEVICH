package by.kiselevich.taskOOP.entity.child;

import by.kiselevich.taskOOP.entity.toy.Toy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class Child {

    private static final Logger LOGGER = LogManager.getLogger(Child.class);

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

        if (age != child.age) return false;
        if (hours != child.hours) return false;
        if (firstName != null ? !firstName.equals(child.firstName) : child.firstName != null) return false;
        return lastName != null ? lastName.equals(child.lastName) : child.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + hours;
        return result;
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

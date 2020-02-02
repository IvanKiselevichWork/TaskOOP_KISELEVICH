package by.kiselevich.taskOOP.entity.child;

import by.kiselevich.taskOOP.entity.toy.Toy;
import by.kiselevich.taskOOP.repository.ToyRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class Child implements Callable<List<Toy>> {
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
    public List<Toy> call() throws Exception {
        Thread.sleep(hours * 1000);
        List<Toy> returnedToys = toys;
        toys = null;
        return returnedToys;
    }

    protected void removeMoneyForToys() {
        BigDecimal sumToys = BigDecimal.valueOf(0);
        for (Toy toy : toys) {
            sumToys = sumToys.add(toy.getCost());
        }
        sumToys = sumToys.multiply(BigDecimal.valueOf(hours));
        budget = budget.subtract(sumToys);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}

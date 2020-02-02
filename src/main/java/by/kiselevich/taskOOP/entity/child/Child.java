package by.kiselevich.taskOOP.entity.child;

import by.kiselevich.taskOOP.entity.toy.Toy;

import java.util.List;

public abstract class Child {
    private String firstName;
    private String lastName;

    protected List<Toy> toys;

    public static class Builder {

        private String firstName;
        private String lastName;
        private Integer age;

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
            return child;
        }

    }

    public abstract void receiveToys();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
        return "Child{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

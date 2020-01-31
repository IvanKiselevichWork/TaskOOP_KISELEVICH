package by.kiselevich.taskOOP.builder;

import by.kiselevich.taskOOP.entity.child.Child;
import by.kiselevich.taskOOP.entity.child.MiddleChild;
import by.kiselevich.taskOOP.entity.child.OlderChild;
import by.kiselevich.taskOOP.entity.child.YoungerChild;

public class ChildBuilder {

    private Child child;

    public void buildChild(String firstName, String lastName, int age) {
        if (age >= 2 && age < 7) {
            child = new YoungerChild(firstName, lastName);
        } else if (age >= 7 && age < 12) {
            child = new MiddleChild(firstName, lastName);
        } else {
            child = new OlderChild(firstName, lastName);
        }
    }

    public Child getChild() {
        return child;
    }
}

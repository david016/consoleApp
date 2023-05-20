package services;

import models.Person;

import java.util.ArrayList;
import java.util.List;

public class AppHandler {
    private ConsoleHandler consoleHandler = new ConsoleHandler();
    private List<Person> people = new ArrayList<>();

    public void startApp() {
        String userAction = consoleHandler.getUserAction();
        switch (userAction) {
            case "a":
                addPerson();
        }
    }

    private void addPerson() {
        people.add(consoleHandler.askForPersonInfo());
    }

    public List<Person> getPeople() {
        return people;
    }
};
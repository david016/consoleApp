package services;

import models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppHandler {
    private final ConsoleHandler consoleHandler = new ConsoleHandler();
    private final List<Person> people = new ArrayList<>();

    public void startApp() throws Exception {
        String userAction = consoleHandler.getUserAction();
        while (!userAction.equals("q")) {
            switch (userAction) {
                case "a":
                    addPerson();
                    break;
                case "r":
                    removePerson();
                    break;
                case "q":
                    break;
            }
            userAction = consoleHandler.getUserAction();
        }
    }

    private void removePerson() throws Exception {
        Person person = consoleHandler.askForPersonInfo();
        for (Person p : people) {
            if (Objects.equals(p, person)) {
                people.remove(p);
                break;
            }
        }
        throw new Exception("Person doesn't exist.");
    }

    private void addPerson() throws Exception {
        Person newPerson = consoleHandler.askForPersonInfo();
        for (Person p : people) {
            if (Objects.equals(p, newPerson)) {
                throw new Exception("Person already exists.");
            }
        }
        people.add(newPerson);
    }

    public List<Person> getPeople() {
        return people;
    }
}
package services;

import models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class AppHandler {
    private final ConsoleHandler consoleHandler = new ConsoleHandler();
    private final List<Person> people = new ArrayList<>();

    public void startApp() {
        String userAction = consoleHandler.getUserAction();
        while (!userAction.equals("q")) {
            switch (userAction) {
                case "a" -> addPerson();
                case "r" -> removePerson();
                case "s" -> searchPerson();
                default -> System.out.println("Unsupported command.");
            }
            userAction = consoleHandler.getUserAction();
        }
    }

    private Person searchPerson() throws NoSuchElementException {
        String id = consoleHandler.getIdNum();
        for (Person p: people) {
            if (p.getIdentificationNumber().equals(id)){
                System.out.println(p);
                return p;
            }
        }
        throw new NoSuchElementException("Person doesn't exist.");
    }

    private void removePerson() throws NoSuchElementException {
        Person person = searchPerson();
        for (Person p : people) {
            if (Objects.equals(p, person)) {
                people.remove(p);
                return;
            }
        }
        throw new NoSuchElementException("Person doesn't exist.");
    }

    private void addPerson() throws IllegalStateException {
        Person newPerson = consoleHandler.askForPersonInfo();
        for (Person p : people) {
            if (Objects.equals(p, newPerson)) {
                throw new IllegalStateException("Person already exists.");
            }
        }
        people.add(newPerson);
    }

    public List<Person> getPeople() {
        return people;
    }
}
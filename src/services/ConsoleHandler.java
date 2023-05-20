package services;

import models.Person;

import java.util.*;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private final Scanner scanner = new Scanner(System.in);

    public String getUserAction() {
        String userInput;
        List<String> possibleInputs = new ArrayList<>(Arrays.asList("a", "r", "s", "q"));

        System.out.println("What do you want to do?");
        do {
            promptUser();
            userInput = scanner.nextLine();
        } while (!possibleInputs.contains(userInput));
        return userInput;
    }

    private void promptUser() {
        System.out.println("------------------------------");
        System.out.println("Press 'a' to add new person.");
        System.out.println("Press 'r' to remove a person.");
        System.out.println("Press 's' to search a person.");
        System.out.println("Press 'q' to quit.");
        System.out.println("------------------------------");
        System.out.print("You input: ");
    }

    public Person askForPersonInfo() {
        String name, surname, idNUmber;

        name = getName("name");
        surname = getName("surname");
        idNUmber = getIdNum();
        return new Person(name, surname, idNUmber);
    }

    private String getName(String nameOrSurname) {
        String name;
        System.out.print("Write a " + nameOrSurname + ": ");
        do {
            name = scanner.nextLine();
        } while (name.length() == 0);
        return name;
    }

    private String getIdNum() {
        String id;
        do {
            System.out.print("Write an idNumber (YYMMDDXXXX / YYMMDD/XXXX): ");
            id = scanner.nextLine();
        } while (!isValid(id));
        return id;
    }

    private boolean isValid(String id) {
        String regexPattern = "\\d{6}(/)?\\d{4}";
        return Pattern.matches(regexPattern, id);
    }
}

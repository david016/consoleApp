package services;

import models.Person;

import java.util.*;
import java.util.regex.Pattern;

public class ConsoleHandler {
    private final String separator = "------------------------------";
    private final Scanner scanner = new Scanner(System.in);

    public String getUserAction() {
        System.out.println(separator);
        System.out.println("What do you want to do?");
        promptUser();
        return scanner.nextLine();
    }

    private void promptUser() {
        System.out.println(separator);
        System.out.println("Press 'a' to add new person.");
        System.out.println("Press 'r' to remove a person.");
        System.out.println("Press 's' to search a person.");
        System.out.println("Press 'q' to quit.");
        System.out.println(separator);
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

    public String getIdNum() {
        String id;
        do {
            System.out.print("Write an idNumber (YYMMDDXXXX or YYMMDD/XXXX): ");
            id = scanner.nextLine();
        } while (!isValid(id));
        return id;
    }

    private boolean isValid(String id) {
        String regexPattern = "\\d{6}(/)?\\d{4}";
        return Pattern.matches(regexPattern, id);
    }
}

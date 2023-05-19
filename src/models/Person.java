package models;

public class Person {
    private String name;
    private String surname;
    private final int identificationNumber;

    public Person(String name, String surname, int identificationNumber) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
    }
}

package models;

public class Person {
    private String name;
    private String surname;
    private final String identificationNumber;

    public Person(String name, String surname, String identificationNumber) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + identificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return this.name.equals(that.name) &&
                this.surname.equals(that.surname) &&
                this.identificationNumber.equals(that.identificationNumber);
    }
}

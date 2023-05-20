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
        return  "Name: "+ name + " " + surname + ", " + "Id: "+ identificationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        // people should not have same id number so I guess checking this is enough
        return this.identificationNumber.equals(((Person) o).identificationNumber);
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }
}

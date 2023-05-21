package models;

import services.MyDateFormatter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String surname;
    private final String identificationNumber;
    private final boolean bornBefore2000;

    public Person(String name, String surname, String identificationNumber, boolean bornBefore2000) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = MyDateFormatter.removeSlashFromId(identificationNumber);
        this.bornBefore2000 = bornBefore2000;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = MyDateFormatter.getFormatter(bornBefore2000);
        int age;

        LocalDate birthDate = LocalDate.parse(identificationNumber.substring(0, 6), formatter);
        LocalDate now = LocalDate.now();
        age = Period.between(birthDate, now).getYears();

        return "Name: " + name + " " + surname + ", " + "Id: " + identificationNumber + ", Age: " + age;
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
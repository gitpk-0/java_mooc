package com.example.part13_javafx_projects.part_13;

import java.util.ArrayList;
import java.util.Collection;

public class PersonWarehouseOne implements PersonWarehouse {

    ArrayList<Person> persons;

    public PersonWarehouseOne() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public Person search(String socialSecurityNumber) {
        for (Person person : persons) {
            if (person.getSsn().equals(socialSecurityNumber)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void delete(Person person) {
        for (Person item : persons) {
            if (person.getSsn().equals(item.getSsn())) {
                persons.remove(person);
            }
        }
    }

    @Override
    public void delete(String socialSecurityNumber) {
        for (Person person : persons) {
            if (person.getSsn().equals(socialSecurityNumber)) {
                persons.remove(person);
            }
        }
    }

    @Override
    public void deleteAll() {
        this.persons = new ArrayList<>();
    }

    @Override
    public Collection<Person> getAll() {
        return persons;
    }

    public void printAll() {
        persons.stream().forEach(person -> System.out.println(person.getName() + ": " + person.getSsn()));
    }
}

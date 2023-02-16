package com.example.part13_javafx_projects.part_13;

import java.util.Collection;

public interface PersonWarehouse {
    void save(Person person);
    Person search(String socialSecurityNumber);

    void delete(Person person);
    void delete(String socialSecurityNumber);
    void deleteAll();

    Collection<Person> getAll();

    void printAll();
}
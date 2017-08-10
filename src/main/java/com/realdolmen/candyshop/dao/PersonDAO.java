package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import java.util.List;


public interface PersonDAO {

    Long createPerson (Person person);
    List<Person> findAllPeople();

    Person findPersonById(Long id);
    Person updatePerson(Person person);
    void deletePerson (Person person);
    long countAllPeople();
    List<Person> findByLastName(String lastName);

}

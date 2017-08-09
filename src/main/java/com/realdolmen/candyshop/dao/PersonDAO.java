package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import java.util.List;


public interface PersonDAO {

    Long createPerson (Person person);
    List<Person> findAllPeople();


}

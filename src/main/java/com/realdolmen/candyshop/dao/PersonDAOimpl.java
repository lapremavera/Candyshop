package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by vdabcursist on 08/08/2017.
 */
public class PersonDAOimpl implements PersonDAO {

    EntityManager em;



    @Override
    public Long createPerson(Person person) {
        em.persist(person);
        return person.getId();
    }

    @Override
    public List<Person> findAllPeople() {

        return em.createQuery("SELECT p FROM Person p",Person.class).getResultList();
    }
}

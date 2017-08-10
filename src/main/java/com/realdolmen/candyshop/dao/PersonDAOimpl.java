package com.realdolmen.candyshop.dao;

import com.realdolmen.candyshop.entities.Person;

import javax.persistence.EntityManager;
import java.util.List;


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
    @Override
    public Person findPersonById(Long id){
        return em.find(Person.class,id);

    }
    @Override
    public Person updatePerson (Person person){
        return em.merge(person);
    }
    @Override
    public void deletePerson(Person person){
        em.remove(em.merge(person));    //je moet eerst je person manageble maken, eer je het kan removen
    }

    @Override
    public long countAllPeople() {
        return em.createQuery("select count(p) from Person p", Long.class).getSingleResult();
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return em.createNamedQuery("FIND_BY_LAST_NAME",Person.class).setParameter("lname",lastName).getResultList();
    }


}

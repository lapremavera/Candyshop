package com.realdolmen.candyshop.main;

import com.realdolmen.candyshop.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("candyshop");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Person person = new Person("John", "Doe", "2011-01-01");
        em.persist(person);

        Order order = new Order(person,new Adress("Gentweg","a","a","a", "Gent"));
        em.persist(order);

        Candy candy = new Candy("Veter", Candycolor.BLUE);
        em.persist(candy);

        OrderLine orderLine1 = new OrderLine(12,candy);
        em.persist(orderLine1);

        order.addOrderLine(orderLine1);


        order.calculateTotal();
        tx.commit();

        List<Person> people = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        people.forEach(System.out::println);


        em.close();
        emf.close();

    }
}

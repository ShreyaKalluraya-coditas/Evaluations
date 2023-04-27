package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
    public static void insert(Bank bank){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bank);
        em.getTransaction().commit();
        em.close();
    }
}

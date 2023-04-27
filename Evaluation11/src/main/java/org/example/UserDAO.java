package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAO {
   static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
   public static void insert(User user){
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();
      em.close();
   }





}

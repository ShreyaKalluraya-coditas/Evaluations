package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PublicationDAO {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();


    public static void insert(Publication publication) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(publication);
        transaction.commit();
        session.close();
    }
}

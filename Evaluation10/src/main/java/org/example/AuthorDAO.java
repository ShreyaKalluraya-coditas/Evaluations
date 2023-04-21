package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuthorDAO {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static void insert(Author author){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }


    public static void delete(int ids) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author author = session.get(Author.class,ids);
        session.delete(author);
        transaction.commit();

    }
}

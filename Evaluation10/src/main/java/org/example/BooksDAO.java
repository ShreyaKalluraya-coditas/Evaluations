package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class BooksDAO {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();

    public static void insert(Books b1) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(b1);
        transaction.commit();
        session.close();
    }

    public static void insertAll(List<Books> books) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Books book : books) {

            session.persist(book);
        }
        transaction.commit();
        session.close();


    }

    public static void update(int id, String names) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql ="UPDATE Books set title =: name where id =: id";
        Query query = session.createQuery(sql);
        query.setParameter("name",names);
        query.setParameter("id",id);
        query.executeUpdate();
        transaction.commit();


    }

    public static void updateQuery(int bid, String option, String value) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Books book = session.get(Books.class,bid);
        if(option.equals("content")){
            book.setContent(value);
        }else if(option.equals("price")){
            book.setPrice(Integer.parseInt(value));
        }
        else if(option.equals("title")){
            book.setTitle(value);
        }
        transaction.commit();

    }
}

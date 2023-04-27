package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AccountDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");

    public static void delete(int accid) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class,accid);
        em.remove(account);
        em.getTransaction().commit();
        em.close();
    }

    public static void update() {


        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();

        CriteriaBuilder cb = em1.getCriteriaBuilder();
        CriteriaUpdate<Account> update = cb.createCriteriaUpdate(Account.class);
        Root<Account> root = update.from(Account.class);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -3);
        Date threeMonthsAgo = calendar.getTime();

        update.set(root.get("status"), "prime")
                .where(cb.and(cb.greaterThan(root.get("balance"), 1000000),
                        cb.lessThanOrEqualTo(root.get("openDate"), threeMonthsAgo)));

        int i = em1.createQuery(update).executeUpdate();
        em1.getTransaction().commit();
        em1.close();


    }

    public static void query() {
        EntityManager em1 = emf.createEntityManager() ;
        em1.getTransaction().begin();
        CriteriaBuilder cb = em1.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        Join<User, Account> accountJoin = userRoot.join("account");

        query.select(userRoot).distinct(true)
                .where(cb.lessThan(accountJoin.get("openDate"), new Date(2023-1900,01,01)));

        List<User> users = em1.createQuery(query).getResultList();
        System.out.println(users);
        em1.getTransaction().commit();
        em1.close();

    }

    public static void query2(int aid) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EntityManager em2 = emf.createEntityManager() ;
        em2.getTransaction().begin();
        Account account = em2.find(Account.class,aid);
        String accountName =  account.getAccountName();
        System.out.println("Enter The number of months you have not been activated");
        int actid = Integer.parseInt(br.readLine());
        if(accountName.equalsIgnoreCase("Current")){
            int balance = Integer.parseInt(account.getBalance());
            if(balance<100000){
                System.out.println("Insufficient Balance");
                int bal = actid * 250;
                balance = balance-bal;
                account.setBalance(String.valueOf(balance));
                em2.merge(account);
            }
        }
        else if(accountName.equalsIgnoreCase("Savings")){
            int balance = Integer.parseInt(account.getBalance());
            if(balance<10000){
                System.out.println("Insufficient Balance");
                int bal = actid * 150;
                balance = balance-bal;
                account.setBalance(String.valueOf(balance));
                em2.merge(account);
            }
        }
        em2.getTransaction().commit();
        em2.close();
    }
}

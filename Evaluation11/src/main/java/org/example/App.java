package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//BANK SPECIFIC
//many customer can have many accounts
//and one account is of that one bank
public class App 
{
    public static void main( String[] args ) throws IOException, ParseException {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag){
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 to enter the detials of user");
            System.out.println("Press 2 to enter the detials of account");
            System.out.println("Press 3 to enter the detials of bank");
            System.out.println("Press 4 to select all the users who have opened their account on or before 1sJan 2023");
            System.out.println("Press 5 to update all the users who have balance >100000 their status to prime ");
            System.out.println("Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs " +
                    "    if savings and balanece less than 1000000 cut 150 rs");
            System.out.println("Press 7 to delete account");
            System.out.println("Press 8 to retrieve account details");
            int ch = Integer.parseInt(br.readLine());
            switch(ch){
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("Enter the name");
                    String uname = br.readLine();
                    System.out.println("Enter the address");
                    String uaddress = br.readLine();
                    User user = new User();
                    user.setName(uname);
                    user.setAddress(uaddress);
                    UserDAO.insert(user);
                    break;
                case 2:
                    EntityManager em = emf.createEntityManager();
                    em.getTransaction().begin();
                    System.out.println("Enter the user ID");
                    int uid = Integer.parseInt(br.readLine());
                    User users = em.find(User.class,uid);
                    List<Account> acc = new ArrayList<>();
                    System.out.println("No of Accounts you want in this bank");
                    int noacc = Integer.parseInt(br.readLine());
                    for(int i=0;i<noacc;i++){
                        System.out.println("Enter the detail of "+i+1);
                        System.out.println("Enter the Type of Acount You Want(Savings/Current/Salary)");
                        Account account = new Account();
                        String typeAcc = br.readLine();
                        if(typeAcc.equalsIgnoreCase("Savings")){
                            account.setAccountName("Savings");
                            System.out.println("Enter the Pan Details ");
                            String pan = br.readLine();
                            account.setPanNumber(pan);
                            System.out.println("Enter the balance");
                            String balance = br.readLine();
                            account.setBalance(balance);
                            System.out.println("Enter the date of Opening account");
                            String odate = br.readLine();
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
                            account.setOpenDate(date);
                            acc.add(account);
                        }
                        else if(typeAcc.equalsIgnoreCase("Current")){
                            account.setAccountName("Current");
                            System.out.println("Enter the GST ID");
                            String gst = br.readLine();
                            account.setGstId(gst);
                            System.out.println("Enter the Firm Name");
                            String firmName = br.readLine();
                            account.setFirmName(firmName);
                            System.out.println("Enter teh Balance");
                            String balance = br.readLine();
                            account.setBalance(balance);
                            System.out.println("Enter the date of Opening account");
                            String odate = br.readLine();
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
                            account.setOpenDate(date);
                            acc.add(account);
                        }
                        else if(typeAcc.equalsIgnoreCase("Salary")){
                            account.setAccountName("Salary");
                            System.out.println("Ente rthe Comapny Name ");
                            String compName = br.readLine();
                            account.setCompanyName(compName);
                            System.out.println("Enter teh Balance");
                            String balance = br.readLine();
                            account.setBalance(balance);
                            System.out.println("Enter the date of Opening account");
                            String odate = br.readLine();
                            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(odate);
                            account.setOpenDate(date);
                            acc.add(account);
                        }

                    }
                    users.setAccount(acc);
                    em.merge(users);
                    em.getTransaction().commit();
                    em.close();
                    break;
                case 3:
                    System.out.println("Enter the Bank Name ");
                    String bankName = br.readLine();
                    System.out.println("Enter the AccountID");
                    int id = Integer.parseInt(br.readLine());
                    EntityManager em3 = emf.createEntityManager();
                    em3.getTransaction().begin();
                    Account account = em3.find(Account.class,id);
                    Bank bank = new Bank();
                    bank.setName(bankName);
                    bank.setAccount(account);
//                  BankDAO.insert(bank);
                    em3.persist(bank);
                    account.setBank(bank);
                    em3.getTransaction().commit();
                    em3.close();
                    break;
                case 4:
                    AccountDAO.query();
                    break;
                case 5:
                     AccountDAO.update();
                    break;
                case 6:
                    System.out.println("Enter the account ID");
                    int aid = Integer.parseInt(br.readLine());
                      AccountDAO.query2(aid);
                    break;
                case 7:
                    System.out.println("Enter the id of account you want to delete");
                    int accid = Integer.parseInt(br.readLine());
                    AccountDAO.delete(accid);
                    break;
                case 8:
                    EntityManager em8 = emf.createEntityManager();
                    em8.getTransaction().begin();
                    List<Account> accounts = em8.createQuery("SELECT a FROM Account a", Account.class).getResultList();
                    System.out.println(accounts);
                    em8.getTransaction().commit();
                    em8.close();
                    break;
            }
        }
    }
}




//OUTPUT


//        Apr 27, 2023 2:57:03 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
//        INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
//        Apr 27, 2023 2:57:04 PM org.hibernate.Version logVersion
//        INFO: HHH000412: Hibernate ORM core version 5.6.5.Final
//        Apr 27, 2023 2:57:04 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
//INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
//        Apr 27, 2023 2:57:05 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//        WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//        Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
//        Apr 27, 2023 2:57:05 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/jpa_evaluation?createDatabaseIfNotExist=true]
//        Apr 27, 2023 2:57:05 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001001: Connection properties: {password=****, user=root}
//        Apr 27, 2023 2:57:05 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001003: Autocommit mode: false
//        Apr 27, 2023 2:57:05 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//        Apr 27, 2023 2:57:06 PM org.hibernate.dialect.Dialect <init>
//INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
//        Apr 27, 2023 2:57:09 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//        INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@7343922c] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//        Apr 27, 2023 2:57:09 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//        INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        1
//        Enter the name
//        Latha
//        Enter the address
//        Dewas
//        Apr 27, 2023 2:58:49 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
//        INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//        WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/jpa_evaluation?createDatabaseIfNotExist=true]
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001001: Connection properties: {password=****, user=root}
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001003: Autocommit mode: false
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//        Apr 27, 2023 2:58:49 PM org.hibernate.dialect.Dialect <init>
//INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
//        Apr 27, 2023 2:58:49 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//        INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@49e4c2d5] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//        Apr 27, 2023 2:58:49 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//        INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//        Hibernate:
//        insert
//        into
//        User
//        (address, name)
//        values
//        (?, ?)
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        2
//        Enter the user ID
//        3
//        Hibernate:
//        select
//        user0_.id as id1_2_0_,
//        user0_.address as address2_2_0_,
//        user0_.name as name3_2_0_
//        from
//        User user0_
//        where
//        user0_.id=?
//        No of Accounts you want in this bank
//        3
//        Enter the detail of 01
//        Enter the Type of Acount You Want(Savings/Current/Salary)
//        Savings
//        Enter the Pan Details
//        5358759
//        Enter the balance
//        5000
//        Enter the date of Opening account
//        2022-12-12
//        Enter the detail of 11
//        Enter the Type of Acount You Want(Savings/Current/Salary)
//        Current
//        Enter the GST ID
//        55769869
//        Enter the Firm Name
//        Prakash
//        Enter teh Balance
//        5000
//        Enter the date of Opening account
//        2021-09-09
//        Enter the detail of 21
//        Enter the Type of Acount You Want(Savings/Current/Salary)
//        Salary
//        Ente rthe Comapny Name
//        Coditas Solutions LLP
//        Enter teh Balance
//        500000
//        Enter the date of Opening account
//        2002-12-12
//        Hibernate:
//        insert
//        into
//        Account
//        (CompanyName, GstId, accountName, balance, bank_id, firmName, openDate, panNumber, status)
//        values
//        (?, ?, ?, ?, ?, ?, ?, ?, ?)
//        Hibernate:
//        insert
//        into
//        Account
//        (CompanyName, GstId, accountName, balance, bank_id, firmName, openDate, panNumber, status)
//        values
//        (?, ?, ?, ?, ?, ?, ?, ?, ?)
//        Hibernate:
//        insert
//        into
//        Account
//        (CompanyName, GstId, accountName, balance, bank_id, firmName, openDate, panNumber, status)
//        values
//        (?, ?, ?, ?, ?, ?, ?, ?, ?)
//        Hibernate:
//        delete
//        from
//        User_Account
//        where
//        user_id=?
//        Hibernate:
//        insert
//        into
//        User_Account
//        (user_id, account_id)
//        values
//        (?, ?)
//        Hibernate:
//        insert
//        into
//        User_Account
//        (user_id, account_id)
//        values
//        (?, ?)
//        Hibernate:
//        insert
//        into
//        User_Account
//        (user_id, account_id)
//        values
//        (?, ?)
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        3
//        Enter the Bank Name
//        SBI
//        Enter the AccountID
//        6
//        Hibernate:
//        select
//        account0_.id as id1_0_0_,
//        account0_.CompanyName as companyn2_0_0_,
//        account0_.GstId as gstid3_0_0_,
//        account0_.accountName as accountn4_0_0_,
//        account0_.balance as balance5_0_0_,
//        account0_.bank_id as bank_id10_0_0_,
//        account0_.firmName as firmname6_0_0_,
//        account0_.openDate as opendate7_0_0_,
//        account0_.panNumber as pannumbe8_0_0_,
//        account0_.status as status9_0_0_,
//        bank1_.id as id1_1_1_,
//        bank1_.name as name2_1_1_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.id=?
//        Hibernate:
//        insert
//        into
//        Bank
//        (name)
//        values
//        (?)
//        Hibernate:
//        update
//        Account
//        set
//        CompanyName=?,
//        GstId=?,
//        accountName=?,
//        balance=?,
//        bank_id=?,
//        firmName=?,
//        openDate=?,
//        panNumber=?,
//        status=?
//        where
//        id=?
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        4
//        Apr 27, 2023 3:00:33 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
//        INFO: HHH000204: Processing PersistenceUnitInfo [name: rt]
//        Apr 27, 2023 3:00:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//        WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//        Apr 27, 2023 3:00:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/jpa_evaluation?createDatabaseIfNotExist=true]
//        Apr 27, 2023 3:00:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001001: Connection properties: {password=****, user=root}
//        Apr 27, 2023 3:00:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001003: Autocommit mode: false
//        Apr 27, 2023 3:00:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//        Apr 27, 2023 3:00:33 PM org.hibernate.dialect.Dialect <init>
//INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
//        Apr 27, 2023 3:00:34 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//        INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@46fb0c33] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//        Apr 27, 2023 3:00:34 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//        INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//        Hibernate:
//        select
//        distinct user0_.id as id1_2_,
//        user0_.address as address2_2_,
//        user0_.name as name3_2_
//        from
//        User user0_
//        inner join
//        User_Account account1_
//        on user0_.id=account1_.user_id
//        inner join
//        Account account2_
//        on account1_.account_id=account2_.id
//        where
//        account2_.openDate<?
//[User{id=1, name='Shreya', address='Dewas'}, User{id=3, name='Latha', address='Dewas'}]
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        6
//        Enter the account ID
//        8
//        Hibernate:
//        select
//        account0_.id as id1_0_0_,
//        account0_.CompanyName as companyn2_0_0_,
//        account0_.GstId as gstid3_0_0_,
//        account0_.accountName as accountn4_0_0_,
//        account0_.balance as balance5_0_0_,
//        account0_.bank_id as bank_id10_0_0_,
//        account0_.firmName as firmname6_0_0_,
//        account0_.openDate as opendate7_0_0_,
//        account0_.panNumber as pannumbe8_0_0_,
//        account0_.status as status9_0_0_,
//        bank1_.id as id1_1_1_,
//        bank1_.name as name2_1_1_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.id=?
//        Enter The number of months you have not been activated
//        3
//        Insufficient Balance
//        Hibernate:
//        update
//        Account
//        set
//        CompanyName=?,
//        GstId=?,
//        accountName=?,
//        balance=?,
//        bank_id=?,
//        firmName=?,
//        openDate=?,
//        panNumber=?,
//        status=?
//        where
//        id=?
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        6
//        Enter the account ID
//        7
//        Hibernate:
//        select
//        account0_.id as id1_0_0_,
//        account0_.CompanyName as companyn2_0_0_,
//        account0_.GstId as gstid3_0_0_,
//        account0_.accountName as accountn4_0_0_,
//        account0_.balance as balance5_0_0_,
//        account0_.bank_id as bank_id10_0_0_,
//        account0_.firmName as firmname6_0_0_,
//        account0_.openDate as opendate7_0_0_,
//        account0_.panNumber as pannumbe8_0_0_,
//        account0_.status as status9_0_0_,
//        bank1_.id as id1_1_1_,
//        bank1_.name as name2_1_1_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.id=?
//        Enter The number of months you have not been activated
//        4
//        Insufficient Balance
//        Hibernate:
//        update
//        Account
//        set
//        CompanyName=?,
//        GstId=?,
//        accountName=?,
//        balance=?,
//        bank_id=?,
//        firmName=?,
//        openDate=?,
//        panNumber=?,
//        status=?
//        where
//        id=?
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        5
//        Hibernate:
//        update
//        Account
//        set
//        status=?
//        where
//        balance>1000000
//        and openDate<=?
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//        8
//        Hibernate:
//        select
//        account0_.id as id1_0_,
//        account0_.CompanyName as companyn2_0_,
//        account0_.GstId as gstid3_0_,
//        account0_.accountName as accountn4_0_,
//        account0_.balance as balance5_0_,
//        account0_.bank_id as bank_id10_0_,
//        account0_.firmName as firmname6_0_,
//        account0_.openDate as opendate7_0_,
//        account0_.panNumber as pannumbe8_0_,
//        account0_.status as status9_0_
//        from
//        Account account0_
//        Hibernate:
//        select
//        bank0_.id as id1_1_0_,
//        bank0_.name as name2_1_0_,
//        account1_.id as id1_0_1_,
//        account1_.CompanyName as companyn2_0_1_,
//        account1_.GstId as gstid3_0_1_,
//        account1_.accountName as accountn4_0_1_,
//        account1_.balance as balance5_0_1_,
//        account1_.bank_id as bank_id10_0_1_,
//        account1_.firmName as firmname6_0_1_,
//        account1_.openDate as opendate7_0_1_,
//        account1_.panNumber as pannumbe8_0_1_,
//        account1_.status as status9_0_1_
//        from
//        Bank bank0_
//        left outer join
//        Account account1_
//        on bank0_.id=account1_.bank_id
//        where
//        bank0_.id=?
//        Hibernate:
//        select
//        account0_.id as id1_0_1_,
//        account0_.CompanyName as companyn2_0_1_,
//        account0_.GstId as gstid3_0_1_,
//        account0_.accountName as accountn4_0_1_,
//        account0_.balance as balance5_0_1_,
//        account0_.bank_id as bank_id10_0_1_,
//        account0_.firmName as firmname6_0_1_,
//        account0_.openDate as opendate7_0_1_,
//        account0_.panNumber as pannumbe8_0_1_,
//        account0_.status as status9_0_1_,
//        bank1_.id as id1_1_0_,
//        bank1_.name as name2_1_0_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.bank_id=?
//        Hibernate:
//        select
//        bank0_.id as id1_1_0_,
//        bank0_.name as name2_1_0_,
//        account1_.id as id1_0_1_,
//        account1_.CompanyName as companyn2_0_1_,
//        account1_.GstId as gstid3_0_1_,
//        account1_.accountName as accountn4_0_1_,
//        account1_.balance as balance5_0_1_,
//        account1_.bank_id as bank_id10_0_1_,
//        account1_.firmName as firmname6_0_1_,
//        account1_.openDate as opendate7_0_1_,
//        account1_.panNumber as pannumbe8_0_1_,
//        account1_.status as status9_0_1_
//        from
//        Bank bank0_
//        left outer join
//        Account account1_
//        on bank0_.id=account1_.bank_id
//        where
//        bank0_.id=?
//        Hibernate:
//        select
//        account0_.id as id1_0_1_,
//        account0_.CompanyName as companyn2_0_1_,
//        account0_.GstId as gstid3_0_1_,
//        account0_.accountName as accountn4_0_1_,
//        account0_.balance as balance5_0_1_,
//        account0_.bank_id as bank_id10_0_1_,
//        account0_.firmName as firmname6_0_1_,
//        account0_.openDate as opendate7_0_1_,
//        account0_.panNumber as pannumbe8_0_1_,
//        account0_.status as status9_0_1_,
//        bank1_.id as id1_1_0_,
//        bank1_.name as name2_1_0_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.bank_id=?
//        Hibernate:
//        select
//        bank0_.id as id1_1_0_,
//        bank0_.name as name2_1_0_,
//        account1_.id as id1_0_1_,
//        account1_.CompanyName as companyn2_0_1_,
//        account1_.GstId as gstid3_0_1_,
//        account1_.accountName as accountn4_0_1_,
//        account1_.balance as balance5_0_1_,
//        account1_.bank_id as bank_id10_0_1_,
//        account1_.firmName as firmname6_0_1_,
//        account1_.openDate as opendate7_0_1_,
//        account1_.panNumber as pannumbe8_0_1_,
//        account1_.status as status9_0_1_
//        from
//        Bank bank0_
//        left outer join
//        Account account1_
//        on bank0_.id=account1_.bank_id
//        where
//        bank0_.id=?
//        Hibernate:
//        select
//        account0_.id as id1_0_1_,
//        account0_.CompanyName as companyn2_0_1_,
//        account0_.GstId as gstid3_0_1_,
//        account0_.accountName as accountn4_0_1_,
//        account0_.balance as balance5_0_1_,
//        account0_.bank_id as bank_id10_0_1_,
//        account0_.firmName as firmname6_0_1_,
//        account0_.openDate as opendate7_0_1_,
//        account0_.panNumber as pannumbe8_0_1_,
//        account0_.status as status9_0_1_,
//        bank1_.id as id1_1_0_,
//        bank1_.name as name2_1_0_
//        from
//        Account account0_
//        left outer join
//        Bank bank1_
//        on account0_.bank_id=bank1_.id
//        where
//        account0_.bank_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        Hibernate:
//        select
//        user0_.account_id as account_2_3_0_,
//        user0_.user_id as user_id1_3_0_,
//        user1_.id as id1_2_1_,
//        user1_.address as address2_2_1_,
//        user1_.name as name3_2_1_
//        from
//        User_Account user0_
//        inner join
//        User user1_
//        on user0_.user_id=user1_.id
//        where
//        user0_.account_id=?
//        [Account{id=1, accountName='Savings', panNumber='2346', GstId='null', firmName='null', CompanyName='null', balance='4700', status='prime', openDate=2019-09-09, user=[], bank=null}, Account{id=2, accountName='Current', panNumber='null', GstId='788788', firmName='Bhumi', CompanyName='null', balance='5000', status='prime', openDate=2001-09-09, user=[], bank=Bank{id=2, name='IDBI'}}, Account{id=3, accountName='Salary', panNumber='null', GstId='null', firmName='null', CompanyName='Coditas', balance='8598696', status='prime', openDate=2001-09-09, user=[], bank=null}, Account{id=4, accountName='Savings', panNumber='566788', GstId='null', firmName='null', CompanyName='null', balance='4400', status='null', openDate=2023-08-04, user=[User{id=2, name='Aarti', address='Pune'}], bank=Bank{id=4, name='IDBI'}}, Account{id=5, accountName='Current', panNumber='null', GstId='3564575', firmName='Nirma', CompanyName='null', balance='4000', status='null', openDate=2023-08-08, user=[User{id=2, name='Aarti', address='Pune'}], bank=null}, Account{id=6, accountName='Savings', panNumber='5385596', GstId='null', firmName='null', CompanyName='null', balance='689000000', status='prime', openDate=2020-09-09, user=[User{id=1, name='Shreya', address='Dewas'}], bank=Bank{id=5, name='SBI'}}, Account{id=7, accountName='Savings', panNumber='5358759', GstId='null', firmName='null', CompanyName='null', balance='4400', status='null', openDate=2022-12-12, user=[User{id=3, name='Latha', address='Dewas'}], bank=null}, Account{id=8, accountName='Current', panNumber='null', GstId='55769869', firmName='Prakash', CompanyName='null', balance='4250', status='null', openDate=2021-09-09, user=[User{id=3, name='Latha', address='Dewas'}], bank=null}, Account{id=9, accountName='Salary', panNumber='null', GstId='null', firmName='null', CompanyName='Coditas Solutions LLP', balance='500000', status='null', openDate=2002-12-12, user=[User{id=3, name='Latha', address='Dewas'}], bank=null}]
//        Press 0 for exit
//        Press 1 to enter the detials of user
//        Press 2 to enter the detials of account
//        Press 3 to enter the detials of bank
//        Press 4 to select all the users who have opened their account on or before 1sJan 2023
//        Press 5 to update all the users who have balance >100000 their status to prime
//        Press 6 to if cuurent acc and balance greater less than 100000 mssg insufficient balance and cut 250 rs     if savings and balanece less than 1000000 cut 150 rs
//        Press 7 to delete account
//        Press 8 to retrieve account details
//
//mysql> select * from account;
//        +----+-----------------------+----------+-------------+-----------+----------+------------+-----------+--------+---------+
//        | id | CompanyName           | GstId    | accountName | balance   | firmName | openDate   | panNumber | status | bank_id |
//        +----+-----------------------+----------+-------------+-----------+----------+------------+-----------+--------+---------+
//        |  1 | NULL                  | NULL     | Savings     | 4700      | NULL     | 2019-09-09 | 2346      | prime  |    NULL |
//        |  2 | NULL                  | 788788   | Current     | 5000      | Bhumi    | 2001-09-09 | NULL      | prime  |       2 |
//        |  3 | Coditas               | NULL     | Salary      | 8598696   | NULL     | 2001-09-09 | NULL      | prime  |    NULL |
//        |  4 | NULL                  | NULL     | Savings     | 4400      | NULL     | 2023-08-04 | 566788    | NULL   |       4 |
//        |  5 | NULL                  | 3564575  | Current     | 4000      | Nirma    | 2023-08-08 | NULL      | NULL   |    NULL |
//        |  6 | NULL                  | NULL     | Savings     | 689000000 | NULL     | 2020-09-09 | 5385596   | prime  |       5 |
//        |  7 | NULL                  | NULL     | Savings     | 4400      | NULL     | 2022-12-12 | 5358759   | NULL   |    NULL |
//        |  8 | NULL                  | 55769869 | Current     | 4250      | Prakash  | 2021-09-09 | NULL      | NULL   |    NULL |
//        |  9 | Coditas Solutions LLP | NULL     | Salary      | 500000    | NULL     | 2002-12-12 | NULL      | NULL   |    NULL |
//        +----+-----------------------+----------+-------------+-----------+----------+------------+-----------+--------+---------+
//        9 rows in set (0.00 sec)
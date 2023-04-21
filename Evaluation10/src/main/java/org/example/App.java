package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//one author many books
//one book one publication
public class App
{
    public static void main( String[] args ) throws IOException {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag) {

            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for inserting author books and their publication");
            System.out.println("Press 2 for updating name of Book");
            System.out.println("Press 3 for deleting author");
            System.out.println("Press 4 for find all authors who have published their books on or before 1st Jan 2021");
            System.out.println("Press 5 to find all the books by Nirali publication where price >=500");
            System.out.println("Press 6 to Retrieve all books of author whose name starts with A and ends with I");
            System.out.println("Press 7 to update Book as per your choice ");

            int ch = Integer.parseInt(br.readLine());
            switch (ch) {
                case 0:
                    flag = false;
                    break;
                case 1:
                    System.out.println("Enter the name of author");
                    String name = br.readLine();
                    Author author = new Author();
                    List<Books> books = new ArrayList<>();

                    author.setName(name);
                    boolean flags = true;
                    while (flags) {
                        System.out.println("Press 0 To exit or enter the Title of Books");
                        String choice = br.readLine();
                        Publication publication = new Publication();


                        if (choice.equals("0")) {
                            flags = false;
                            break;
                        } else {
                            Books b1 = new Books();
                            b1.setTitle(choice);
                            System.out.println("Enter the content ");
                            String content = br.readLine();
                            b1.setContent(content);
                            System.out.println("Enter the price ");
                            int price = Integer.parseInt(br.readLine());
                            b1.setPrice(price);


                            System.out.println("enter the publication name");
                            String pubName = br.readLine();
                            publication.setPublicationName(pubName);
                            publication.setPublicationDate(new Date());
                            publication.setBooks(b1);
                            b1.setPublication(publication);
                            b1.setAuthor(author);

                            session.save(b1);
                            session.save(publication);
                            books.add(b1);
                        }
                        author.setBook(books);
                        session.save(author);
                    }

                    transaction.commit();

                    break;
                case 2:
                    System.out.println("Enter the name of Book");
                    String names = br.readLine();
                    System.out.println("Enter the id");
                    int id = Integer.parseInt(br.readLine());
                    BooksDAO.update(id,names);



                    break;
                case 3:
                    System.out.println("Enter the id");
                    int ids = Integer.parseInt(br.readLine());
                    AuthorDAO.delete(ids);

                    break;
                case 4:
                    LocalDate localDate = LocalDate.of(2021, 1, 1);
                    Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    String hql = "SELECT a FROM Author a INNER JOIN a.book b INNER JOIN b.publication p WHERE p.publicationDate <= :date";
                    Query query = session.createQuery(hql);
                    query.setParameter("date",date);
                    List<Author> authors = query.getResultList();
                    for(Author aut : authors){
                        System.out.println(aut);
                    }

                    break;
                case 5:
                    String hqls = "SELECT b FROM Books b INNER JOIN b.publication p WHERE p.publicationName = 'Nirali' AND b.price >= 500";
                    Query querys = session.createQuery(hqls);
                    List<Books> book = querys.getResultList();
                    for(Books boo : book){
                        System.out.println(boo);
                    }

                    break;
                case 6:
                    String hq = "SELECT b FROM Author a INNER JOIN a.book b WHERE a.name LIKE 'A%I'";
                    Query q = session.createQuery(hq);
                    List<Books> b = q.getResultList();
                    for (Books bo : b) {
                        System.out.println(bo.getTitle());
                    }

                    break;
                case 7:
                    System.out.println("Enter the id of book");
                    int bid = Integer.parseInt(br.readLine());
                    System.out.println("Enter the field you want to update in Book content,title,price ");
                    String option = br.readLine();
                    System.out.println("Enter the value of it ");
                    String value = br.readLine();
                    BooksDAO.updateQuery(bid,option,value);

                    break;


            }

        }







            }
        }


//OUTPUT


//Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        1
//        Enter the name of author
//        Aashi
//        Press 0 To exit or enter the Title of Books
//        The Mouse
//        Enter the content
//        How are you
//        Enter the price
//        700
//        enter the publication name
//        Prakash
//        Hibernate: insert into Books (author_id, content, price, publication_id, title) values (?, ?, ?, ?, ?)
//        Hibernate: insert into Publication (books_id, publicationDate, publicationName) values (?, ?, ?)
//        Hibernate: insert into Author (name) values (?)
//        Press 0 To exit or enter the Title of Books
//        Siva
//        Enter the content
//        shiv is the greatest
//        Enter the price
//        800
//        enter the publication name
//        Nirali
//        Hibernate: insert into Books (author_id, content, price, publication_id, title) values (?, ?, ?, ?, ?)
//        Hibernate: insert into Publication (books_id, publicationDate, publicationName) values (?, ?, ?)
//        Press 0 To exit or enter the Title of Books
//        0
//        Hibernate: update Books set author_id=?, content=?, price=?, publication_id=?, title=? where id=?
//        Hibernate: update Books set author_id=?, content=?, price=?, publication_id=?, title=? where id=?
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        2
//        Enter the name of Book
//        The Shiva
//        Enter the id
//        2
//        Apr 21, 2023 1:29:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//        WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//        Apr 21, 2023 1:29:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/evaluation10?createDatabaseIfNotExist=true]
//        Apr 21, 2023 1:29:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001001: Connection properties: {password=****, user=root}
//        Apr 21, 2023 1:29:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001003: Autocommit mode: false
//        Apr 21, 2023 1:29:26 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//        Apr 21, 2023 1:29:26 PM org.hibernate.dialect.Dialect <init>
//INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
//        Apr 21, 2023 1:29:26 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//        INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@7e1ffe70] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//        Hibernate: alter table Books add constraint FKf9d3q3ye2l7ogfjq5fwqdvut1 foreign key (author_id) references Author (id)
//        Hibernate: alter table Books add constraint FKj8mal2lk3qe4cgwdxk75500gv foreign key (publication_id) references Publication (id)
//        Hibernate: alter table Publication add constraint FK7msynwlh73lyg2w943a2orjdj foreign key (books_id) references Books (id)
//        Apr 21, 2023 1:29:27 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//        INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//        Hibernate: update Books set title=? where id=?
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        1
//        Enter the name of author
//        Shreya
//        Press 0 To exit or enter the Title of Books
//        Madhavan
//        Enter the content
//        How are you
//        Enter the price
//        690
//        enter the publication name
//        Prakash
//        Hibernate: insert into Books (author_id, content, price, publication_id, title) values (?, ?, ?, ?, ?)
//        Hibernate: insert into Publication (books_id, publicationDate, publicationName) values (?, ?, ?)
//        Hibernate: insert into Author (name) values (?)
//        Press 0 To exit or enter the Title of Books
//        0
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        5
//        Hibernate: select books0_.id as id1_1_, books0_.author_id as author_i5_1_, books0_.content as content2_1_, books0_.price as price3_1_, books0_.publication_id as publicat6_1_, books0_.title as title4_1_ from Books books0_ inner join Publication publicatio1_ on books0_.publication_id=publicatio1_.id where publicatio1_.publicationName='Nirali' and books0_.price>=500
//        Hibernate: select author0_.id as id1_0_0_, author0_.name as name2_0_0_ from Author author0_ where author0_.id=?
//        Hibernate: select publicatio0_.id as id1_2_0_, publicatio0_.books_id as books_id4_2_0_, publicatio0_.publicationDate as publicat2_2_0_, publicatio0_.publicationName as publicat3_2_0_, books1_.id as id1_1_1_, books1_.author_id as author_i5_1_1_, books1_.content as content2_1_1_, books1_.price as price3_1_1_, books1_.publication_id as publicat6_1_1_, books1_.title as title4_1_1_, author2_.id as id1_0_2_, author2_.name as name2_0_2_, publicatio3_.id as id1_2_3_, publicatio3_.books_id as books_id4_2_3_, publicatio3_.publicationDate as publicat2_2_3_, publicatio3_.publicationName as publicat3_2_3_ from Publication publicatio0_ left outer join Books books1_ on publicatio0_.books_id=books1_.id left outer join Author author2_ on books1_.author_id=author2_.id left outer join Publication publicatio3_ on books1_.publication_id=publicatio3_.id where publicatio0_.id=?
//        Books{id=2, title='The Shiva', content='shiv is the greatest', price=800}
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        6
//        Hibernate: select book1_.id as id1_1_, book1_.author_id as author_i5_1_, book1_.content as content2_1_, book1_.price as price3_1_, book1_.publication_id as publicat6_1_, book1_.title as title4_1_ from Author author0_ inner join Books book1_ on author0_.id=book1_.author_id where author0_.name like 'A%I'
//        Hibernate: select publicatio0_.id as id1_2_0_, publicatio0_.books_id as books_id4_2_0_, publicatio0_.publicationDate as publicat2_2_0_, publicatio0_.publicationName as publicat3_2_0_, books1_.id as id1_1_1_, books1_.author_id as author_i5_1_1_, books1_.content as content2_1_1_, books1_.price as price3_1_1_, books1_.publication_id as publicat6_1_1_, books1_.title as title4_1_1_, author2_.id as id1_0_2_, author2_.name as name2_0_2_, publicatio3_.id as id1_2_3_, publicatio3_.books_id as books_id4_2_3_, publicatio3_.publicationDate as publicat2_2_3_, publicatio3_.publicationName as publicat3_2_3_ from Publication publicatio0_ left outer join Books books1_ on publicatio0_.books_id=books1_.id left outer join Author author2_ on books1_.author_id=author2_.id left outer join Publication publicatio3_ on books1_.publication_id=publicatio3_.id where publicatio0_.id=?
//        The Mouse
//        The Shiva
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        4
//        Hibernate: select author0_.id as id1_0_, author0_.name as name2_0_ from Author author0_ inner join Books book1_ on author0_.id=book1_.author_id inner join Publication publicatio2_ on book1_.publication_id=publicatio2_.id where publicatio2_.publicationDate<=?
//        Author{id=1, name='Aashi'}
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice
//        7
//        Enter the id of book
//        1
//        Enter the field you want to update in Book content,title,price
//        content
//        Enter the value of it
//        how are you
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
//        WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001005: using driver [com.mysql.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/evaluation10?createDatabaseIfNotExist=true]
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001001: Connection properties: {password=****, user=root}
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
//        INFO: HHH10001003: Autocommit mode: false
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
//        INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
//        Apr 21, 2023 1:41:37 PM org.hibernate.dialect.Dialect <init>
//        INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
//        Apr 21, 2023 1:41:37 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
//        INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@77c3c037] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
//        Hibernate: alter table Books add constraint FKf9d3q3ye2l7ogfjq5fwqdvut1 foreign key (author_id) references Author (id)
//        Hibernate: alter table Books add constraint FKj8mal2lk3qe4cgwdxk75500gv foreign key (publication_id) references Publication (id)
//        Hibernate: alter table Publication add constraint FK7msynwlh73lyg2w943a2orjdj foreign key (books_id) references Books (id)
//        Apr 21, 2023 1:41:37 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
//        INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
//        Hibernate: select books0_.id as id1_1_0_, books0_.author_id as author_i5_1_0_, books0_.content as content2_1_0_, books0_.price as price3_1_0_, books0_.publication_id as publicat6_1_0_, books0_.title as title4_1_0_, author1_.id as id1_0_1_, author1_.name as name2_0_1_, publicatio2_.id as id1_2_2_, publicatio2_.books_id as books_id4_2_2_, publicatio2_.publicationDate as publicat2_2_2_, publicatio2_.publicationName as publicat3_2_2_, books3_.id as id1_1_3_, books3_.author_id as author_i5_1_3_, books3_.content as content2_1_3_, books3_.price as price3_1_3_, books3_.publication_id as publicat6_1_3_, books3_.title as title4_1_3_ from Books books0_ left outer join Author author1_ on books0_.author_id=author1_.id left outer join Publication publicatio2_ on books0_.publication_id=publicatio2_.id left outer join Books books3_ on publicatio2_.books_id=books3_.id where books0_.id=?
//        Hibernate: update Books set author_id=?, content=?, price=?, publication_id=?, title=? where id=?
//        Press 0 for exit
//        Press 1 for inserting author books and their publication
//        Press 2 for updating name of Book
//        Press 3 for deleting author
//        Press 4 for find all authors who have published their books on or before 1st Jan 2021
//        Press 5 to find all the books by Nirali publication where price >=500
//        Press 6 to Retrieve all books of author whose name starts with A and ends with I
//        Press 7 to update Book as per your choice


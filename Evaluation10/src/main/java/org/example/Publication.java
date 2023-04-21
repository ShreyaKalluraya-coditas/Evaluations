package org.example;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String publicationName;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

   @OneToOne
    private Books books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Publication(String publicationName, Date publicationDate) {
        this.publicationName = publicationName;
        this.publicationDate = publicationDate;
    }

    public Publication(String publicationName, Date publicationDate, Books books) {
        this.publicationName = publicationName;
        this.publicationDate = publicationDate;
        this.books = books;
}
public Publication(){

    }
}

package com.xadmin.usermanagement.bean;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;

    protected String image;

    public User() {
    }

    public User(String name, String email, String country,String image) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        this.image=image;
    }

    public User(int id, String name, String email, String country,String image) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.image = image;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}

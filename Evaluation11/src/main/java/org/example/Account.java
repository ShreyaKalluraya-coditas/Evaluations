package org.example;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountName;
    private String panNumber;
    private String GstId;
    private String firmName;
    private String CompanyName;
    private String balance;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date openDate;


    @ManyToMany(mappedBy = "account")
    private List<User> user;

    @OneToOne(cascade = CascadeType.ALL)
    private Bank bank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getGstId() {
        return GstId;
    }

    public void setGstId(String gstId) {
        GstId = gstId;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Account(){
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", panNumber='" + panNumber + '\'' +
                ", GstId='" + GstId + '\'' +
                ", firmName='" + firmName + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", balance='" + balance + '\'' +
                ", status='" + status + '\'' +
                ", openDate=" + openDate +
                ", user=" + user +
                ", bank=" + bank +
                '}';
    }
}

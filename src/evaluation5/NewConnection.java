package evaluation5;

import java.util.Random;

public class NewConnection {
    String name,email,address,aadhar,simtype;
    int initialBalance,month;
    int mobilno;

    NewConnection(String name,String email,String address,String aadhar,String simtype,int initialBalance){
        this.name=name;
        this.email=email;
        this.address=address;
        this.aadhar=aadhar;
        this.simtype=simtype;
        this.initialBalance=initialBalance;
         month = 1;
        // phoneNumber = (int)(Math.random()*(MAX-MIN+1)+MIN);
        Random random = new Random();
        int mobilno = random.nextInt(900000000) + 1000000000;


    }

    @Override
    public String toString() {
        return "NewConnection{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", simtype='" + simtype + '\'' +
                ", initialBalance=" + initialBalance +
                ", month=" + month +
                ", mobilno=" + mobilno +
                '}';
    }
}

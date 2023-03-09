package evaluation5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NewConnection {
    Scanner sc = new Scanner(System.in);
    String name,email,address,aadhar,simtype;
    int initialBalance,month;
    int mobilno;
    Random random = new Random();
    NewConnection(){

    }

    public static List<NewConnection> connection = new ArrayList<>();
    public NewConnection(String name,String email,String address,String aadhar,String simtype,int initialBalance,int mobilno){
        this.name=name;
        this.email=email;
        this.address=address;
        this.aadhar=aadhar;
        this.simtype=simtype;
        this.initialBalance=initialBalance;
        month = 1;
        this.mobilno=mobilno;
        // phoneNumber = (int)(Math.random()*(MAX-MIN+1)+MIN);
        //mobilno = random.nextInt(900000000) + 1000000000;

    }

    public void display(){
        sc.nextLine();
        System.out.println("Enter your name");
        String name  = sc.nextLine();
        System.out.println("Enter your email");
        String email  = sc.nextLine();
        System.out.println("Enter your address");

        String address  = sc.nextLine();
        System.out.println("Enter your aadhar");

        String aadhar  = sc.nextLine();
        System.out.println("Enter your simtype");

        String simtype  = sc.nextLine();
        System.out.println("Enter your initialbalance");
        int balance = sc.nextInt();
        Random random = new Random();
        int mobileNo = random.nextInt(900000000) + 1000000000;

        connection.add(new NewConnection(name,email,address,aadhar,simtype,balance,mobileNo));
    }

    @Override
    public String toString() {
        return "NewConnection{" +
                "sc=" + sc +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", simtype='" + simtype + '\'' +
                ", initialBalance=" + initialBalance +
                ", month=" + month +
                ", mobilno=" + mobilno +
                ", random=" + random +
                '}';
    }
}

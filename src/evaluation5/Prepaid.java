package evaluation5;

import java.util.Scanner;

public class Prepaid {
    Scanner sc = new Scanner(System.in);
    public void display(){
         System.out.println("Enter your phone number of 10 digits");




        System.out.println("Enter your choice ");
        System.out.println("Press 0 for exit");
        System.out.println("Press 1 check balance");
        System.out.println("Press 2 for recharge");

        int ch = sc.nextInt();
        switch(ch){
            case 0:
                System.exit(0);
                break;
            case 1:

                break;
            case 2:

                break;
            default:
                System.out.println("Chooce the correct option");

        }



    }
}

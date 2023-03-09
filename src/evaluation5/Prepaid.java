package evaluation5;

import java.util.Scanner;

public class Prepaid extends NewConnection{
    public void prepaid() {
        System.out.println("Enter phone number ");
        long num = sc.nextLong();
        boolean flag = true;
         boolean check = false;
        for (NewConnection s1 : connection) {
            if (s1.mobilno == num) {
                check = true;
            }
        }

           if(check) {
               while (flag) {
                   System.out.println("Enter your choice ");
                   System.out.println("Press 0 for exit");
                   System.out.println("Press 1 check balance");
                   System.out.println("Press 2 for recharge");

                   int ch = sc.nextInt();
                   switch (ch) {
                       case 0:
                           flag = false;
                           break;

                       case 1:

                           for (NewConnection s1 : connection) {
                               if (s1.mobilno == num) {
                                   System.out.println("name='" + s1.name + '\'' +
                                           ", email='" + s1.email + '\'' +
                                           ", address='" + s1.address + '\'' +
                                           ", aadhar='" + s1.aadhar + '\'' +
                                           ", simtype='" + s1.simtype + '\'' +
                                           ", initial Balance=" + s1.initialBalance +
                                           ", month=" + s1.month +
                                           ", mobilno=" + s1.mobilno);

                               }
                           }
                           break;
                       case 2:
                           System.out.println("Enter the  recharge amount");
                           int amount = sc.nextInt();
                           if (amount <= 0) {
                               try {
                                   throw new RechargeAmountTooLowException("should be greater than 1");
                               } catch (Exception e) {
                                   //throw new RuntimeException(e);
                               }
                           }
                           for (NewConnection s2 : connection) {
                               if (s2.mobilno == num) {
                                   s2.initialBalance += amount;
                                   s2.month += 1;
                                   System.out.println("name='" + s2.name + '\'' +
                                           ", email='" + s2.email + '\'' +
                                           ", address='" + s2.address + '\'' +
                                           ", aadhar='" + s2.aadhar + '\'' +
                                           ", simtype='" + s2.simtype + '\'' +
                                           ", initial Balance=" + s2.initialBalance +
                                           ", month=" + s2.month +
                                           ", mobilno=" + s2.mobilno);

                               }
                           }
                           break;
                       default:
                           System.out.println("Enter the desired option ");


                   }
               }
           }else{
               try{
                   throw new UserDoesNotExistException("Register please ");
               }catch(Exception e){

               }

           }
        }
    }


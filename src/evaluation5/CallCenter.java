package evaluation5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<NewConnection> connection = new ArrayList<>();
        while(true){
            System.out.println("Enter your choice");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for prepaid user");
            System.out.println("Press 2 for new connection");
            System.out.println("Press 3 for view all user");

            int choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.exit(0);
                    break;
                case 1 :
                    System.out.println("Enter phone number ");
                    long num = sc.nextLong();
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

                            for(NewConnection s1 : connection){
                                if(s1.mobilno==num)
                                    System.out.println(s1);
                            }
                            break;
                        case 2:
                            System.out.println("Enter the  recharge amount");
                            int amount = sc.nextInt();
                            if(amount<0){
                                try {
                                    throw new RechargeAmountTooLowException("Should be greater than 1");
                                } catch (RechargeAmountTooLowException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            for(NewConnection s2: connection){
                                if(s2.mobilno==num){
                                    s2.initialBalance +=amount;
                                    s2.month += 1;
                                    System.out.println(s2);
                                }
                                else{
                                    try {
                                        throw new UserDoesNotExistException(" please register");
                                    } catch (UserDoesNotExistException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }


                            break;


                    }
                    break;
                case 2:

                     System.out.println("Enter your name");
                     sc.nextLine();
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

                     connection.add(new NewConnection(name,email,address,aadhar,simtype,balance));
                     for(NewConnection c1 : connection){
                         System.out.println(c1);
                     }


                    break;
                case 3:
                    for(NewConnection c1 : connection){
                        System.out.println(c1);
                    }


                    break;
                default:
                    System.out.println("Enter from the desired choice");
            }


        }



    }
}

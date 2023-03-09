package evaluation5;

import java.util.Scanner;

public class CallCenter {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        NewConnection n = new NewConnection();
        DisplayAllUser d = new DisplayAllUser();
        Prepaid p = new Prepaid();
        while(true){
            System.out.println("Press 0 for Exit");
            System.out.println("Press 1 for prepaid ");
            System.out.println("Press 2 for new connection");
            System.out.println("Press 3 for view all user");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    p.prepaid();
                    break;
                case 2:
                    n.display();

                    break;
                case 3:
                    d.displayUser();
                    break;
                default:
                    System.out.println("Enter from the desired choice");


            }

        }

    }
}

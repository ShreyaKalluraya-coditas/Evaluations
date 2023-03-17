package evaluation6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InsertData id = new InsertData();
        RetrieveData rd = new RetrieveData();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter your choice ");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 for Retrieve ");
            System.out.println("Press 2 for Update");
            System.out.println("Press 3 for Delete");
            System.out.println("Press 4 for insert details");
            System.out.println("Press 5 to find all student whose name start with 'Z'");
            System.out.println("Press 6 to Find all teacher whose experience >= 5 and salary >=50000");
            System.out.println("Press 7 to Find all students whose teacher are from pune and teacher name ends with A");
            int choice =sc.nextInt();
            switch(choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    rd.Retrieve();
                    break;
                case 2:
                    rd.Update();
                    break;
                case 3:
                    rd.Delete();
                    break;
                case 4:
                    id.InsertInto();
                    break;
                case 5:
                    rd.Query1();
                    break;
                case 6:
                    rd.Query2();
                    break;
                case 7:
                    rd.Query3();
                    break;
                default:
                    System.out.println("Enter the right choice ");


            }





        }

    }

}



//    Enter your choice
//        Press 0 for exit
//        Press 1 for Retrieve
//        Press 2 for Update
//        Press 3 for Delete
//        Press 4 for insert details
//        Press 5 to find all student whose name start with 'Z'
//        Press 6 to Find all teacher whose experience >= 5 and salary >=50000
//        Press 7 to Find all students whose teacher are from pune and teacher name ends with A
//        5
//        Student Id 2 Name:: Zainab Subject:: C City:: Indore Marks:: 67 Teacher Id:: 2
//        Enter your choice
//        Press 0 for exit
//        Press 1 for Retrieve
//        Press 2 for Update
//        Press 3 for Delete
//        Press 4 for insert details
//        Press 5 to find all student whose name start with 'Z'
//        Press 6 to Find all teacher whose experience >= 5 and salary >=50000
//        Press 7 to Find all students whose teacher are from pune and teacher name ends with A
//        6
//        ID ::1 Name:: Aarti Subject:: Java City:: Pune Salary :: 120000 Exp 11
//        ID ::3 Name:: Krati Subject:: CSharp City:: Pune Salary :: 5000000 Exp 12
//        Enter your choice
//        Press 0 for exit
//        Press 1 for Retrieve
//        Press 2 for Update
//        Press 3 for Delete
//        Press 4 for insert details
//        Press 5 to find all student whose name start with 'Z'
//        Press 6 to Find all teacher whose experience >= 5 and salary >=50000
//        Press 7 to Find all students whose teacher are from pune and teacher name ends with A
//        7
//        Student Name :: Zainab
//        Enter your choice
//        Press 0 for exit
//        Press 1 for Retrieve
//        Press 2 for Update
//        Press 3 for Delete
//        Press 4 for insert details
//        Press 5 to find all student whose name start with 'Z'
//        Press 6 to Find all teacher whose experience >= 5 and salary >=50000
//        Press 7 to Find all students whose teacher are from pune and teacher name ends with A
//        1
//        Enter your choice
//        Press 0 for exit
//        Press 1 to view Student
//        Press 2 to view Teacher
//        1
//        Student Id 1 Name:: Shreya Subject:: Java City:: Dewas Marks:: 56 Teacher Id:: 1
//        Student Id 2 Name:: Zainab Subject:: C City:: Indore Marks:: 67 Teacher Id:: 2
//        Enter your choice
//        Press 0 for exit
//        Press 1 to view Student
//        Press 2 to view Teacher
//        2
//        ID ::1 Name:: Aarti Subject:: Java City:: Pune Salary :: 120000 Exp 11
//        ID ::2 Name:: Zahabiya Subject:: C City:: Mumbai Salary :: 12764 Exp 15
//        ID ::3 Name:: Krati Subject:: CSharp City:: Pune Salary :: 5000000 Exp 12
//        Enter your choice
//        Press 0 for exit
//        Press 1 to view Student
//        Press 2 to view Teacher
//        0
//Enter your choice
//        Press 0 for exit
//        Press 1 for Retrieve
//        Press 2 for Update
//        Press 3 for Delete
//        Press 4 for insert details
//        Press 5 to find all student whose name start with 'Z'
//        Press 6 to Find all teacher whose experience >= 5 and salary >=50000
//        Press 7 to Find all students whose teacher are from pune and teacher name ends with A
//        3
//        Enter your choice
//        Press 0 for exit
//        Press 1 to delete Student
//        Press 2 to delete Teacher
//        1
//        Enter the id of student whom u want to delete
//        1
//        Enter your choice
//        Press 0 for exit
//        Press 1 to delete Student
//        Press 2 to delete Teacher
//        2
//        Enter the id of teacher whom u want to delete
//        1
//        Enter your choice
//        Press 0 for exit
//        Press 1 to delete Student
//        Press 2 to delete Teacher
//        0

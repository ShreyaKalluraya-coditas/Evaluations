package evaluation6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    Connection con = ConnectionToJDBC.connections();
    Scanner sc = new Scanner(System.in);
    InsertData(){

    }
    public void InsertInto(){
        while(true) {
            System.out.println("Enter your choice ");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 to add Teacher Details ");
            System.out.println("Press 2 to add student details ");
            int ch = sc.nextInt();

            switch(ch){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        System.out.println("Enter the id of teacher");
                        int tid = sc.nextInt();
                        System.out.println("Enter the name of teacher");
                        sc.nextLine();
                        String tname = sc.nextLine();
                        System.out.println("Enter the subject of teacher");
                        String tsubject = sc.nextLine();
                        System.out.println("Enter the city of teacher");
                        String tcity = sc.nextLine();
                        System.out.println("Enter the salary of teacher");
                        int tsalary = sc.nextInt();
                        System.out.println("Enter the experience of teacher");
                        int texp = sc.nextInt();

                        PreparedStatement ps = con.prepareStatement("insert into teacher values(?,?,?,?,?,?)");
                        ps.setInt(1,tid);
                        ps.setString(2,tname);
                        ps.setString(3,tsubject);
                        ps.setString(4,tcity);
                        ps.setInt(5,tsalary);
                        ps.setInt(6,texp);

                        ps.executeUpdate();
                        System.out.println("Data inserted succesfully");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


                    break;
                case 2:
                    try {

                        System.out.println("Enter the id of student");
                        int sid = sc.nextInt();
                        System.out.println("Enter the name of student");
                        sc.nextLine();
                        String sname = sc.nextLine();
                        System.out.println("Enter the subject of student");
                        String ssubject = sc.nextLine();
                        System.out.println("Enter the city of student");
                        String scity = sc.nextLine();
                        System.out.println("Enter the marks of studentr");
                        int smarks = sc.nextInt();
                        System.out.println("Enter the id of teacher");
                        int id = sc.nextInt();




                        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
                        ps.setInt(1,sid);
                        ps.setString(2,sname);
                        ps.setString(3,ssubject);
                        ps.setString(4,scity);
                        ps.setInt(5,smarks);
                        ps.setInt(6,id);

                        ps.executeUpdate();
                        System.out.println("Entered details ");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }


                    break;
                default:
                    System.out.println("Enter right choice ");

            }





        }

    }

}

package evaluation6;

import java.sql.*;
import java.util.Scanner;

public class RetrieveData {
    Scanner sc = new Scanner(System.in);
    Connection con = ConnectionToJDBC.connections();

    public void Retrieve() {
        while (true) {
            System.out.println("Enter your choice");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 to view Student");
            System.out.println("Press 2 to view Teacher");
            int cho = sc.nextInt();
            switch (cho) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from student");
                        while (rs.next()) {
                            System.out.println("Student Id " + rs.getInt(1) + " Name:: " + rs.getString(2) + " Subject:: " + rs.getString(3) + " City:: " + rs.getString(4) + " Marks:: " + rs.getInt(5) + " Teacher Id:: " + rs.getInt(6));
                        }

                    } catch (SQLException e) {
                        // throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from teacher");
                        while (rs.next()) {
                            System.out.println(" ID ::" + rs.getInt(1) + " Name:: " + rs.getString(2) + " Subject:: " + rs.getString(3) + " City:: " + rs.getString(4) + " Salary :: " + rs.getInt(5) + " Exp " + rs.getInt(6));
                        }
                    } catch (SQLException e) {
                        //throw new RuntimeException(e);
                    }

                    break;


            }


        }


    }


    public void Delete() {
        while (true) {
            System.out.println("Enter your choice");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 to delete Student");
            System.out.println("Press 2 to delete Teacher");
            int cho = sc.nextInt();
            switch (cho) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        System.out.println("Enter the id of student whom u want to delete");
                        int id = sc.nextInt();
                        Statement st = con.createStatement();
                        String sql = "delete from student where sid =" + id;
                        st.executeUpdate(sql);
                    } catch (SQLException e) {
                        // throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter the id of teacher whom u want to delete");
                        int tid = sc.nextInt();
                        Statement st = con.createStatement();
                        String sql = "delete from teacher where tid =" + tid;
                        st.executeUpdate(sql);
                    } catch (SQLException e) {
                        //throw new RuntimeException(e);
                    }
                    break;


            }
        }

    }

    public void Update() {
        while (true) {
            System.out.println("Enter your choice");
            System.out.println("Press 0 for exit");
            System.out.println("Press 1 to update Student marks ");
            System.out.println("Press 2 to update Teacher salary");
            int cho = sc.nextInt();
            switch (cho) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        System.out.println("Enter the id of student");
                        int id = sc.nextInt();
                        System.out.println("Enter the marks");
                        int marks = sc.nextInt();

                        PreparedStatement ps = con.prepareStatement("update student set smarks = ? where sid = ? ");
                        ps.setInt(1,marks);
                        ps.setInt(2,id);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter the id of teacher");
                        int id = sc.nextInt();
                        System.out.println("Enter the salary");
                        int sal = sc.nextInt();

                        PreparedStatement ps = con.prepareStatement("update teacher set tsalary = ? where tid = ? ");
                        ps.setInt(1,sal);
                        ps.setInt(2,id);

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    break;


            }

        }
    }

    public void Query1(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where sname like 'Z%'");
            while (rs.next()) {
                System.out.println("Student Id " + rs.getInt(1) + " Name:: " + rs.getString(2) + " Subject:: " + rs.getString(3) + " City:: " + rs.getString(4) + " Marks:: " + rs.getInt(5) + " Teacher Id:: " + rs.getInt(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Query2(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where texp>5 and tsalary>50000");
            while (rs.next()) {
                System.out.println(" ID ::" + rs.getInt(1) + " Name:: " + rs.getString(2) + " Subject:: " + rs.getString(3) + " City:: " + rs.getString(4) + " Salary :: " + rs.getInt(5) + " Exp " + rs.getInt(6));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void Query3(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select s.sname from student s inner join teacher t on t.tid = s.tid where t.tcity in('Pune','Mumbai') and t.tname like 'Z%'");
            while(rs.next()){
                System.out.println("Student Name :: "+rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

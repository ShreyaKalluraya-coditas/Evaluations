package Evaluation2;

class Student{
    int id,marks;
    String firstName,lastName,education,city;

    public void displayData(){
        if(marks>=70){
            System.out.println("Distinction");
        }
        else if(marks<70 && marks>=60){
            System.out.println("First Class");
        }
        else if(marks<60 && marks>=55){
            System.out.println("Higher Second Class");
        }
        else if(marks<55 && marks>=50){
            System.out.println("Second Class");
        }
        else if(marks<50 && marks>=35){
            System.out.println("Pass Class");
        }
        else{
            System.out.println("Fail");
        }

    }
}


public class Que1 {
    public static void main(String[] args){
        Student student = new Student();
        student.marks=67;
        student.displayData();
    }
}

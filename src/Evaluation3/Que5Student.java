package Evaluation3;

//HERE THE STUDENT AND TEACHER ARE HAVING SAME ADDRESS
class Address{
    int plotno,houseno;
    String area;

    public Address(int plotno, int houseno, String area) {
        this.plotno = plotno;
        this.houseno = houseno;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plotno=" + plotno +
                ", houseno=" + houseno +
                ", area='" + area + '\'' +
                '}';
    }
}
class Student{
    int id;
    String name;
    Address address;

    public Student(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}


class Teacher{
    int id;
    String name;
    Address address;

    public Teacher(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                '}';
    }
}





public class Que5Student {
    public static void main(String[] args){
        Address address = new Address(23,457,"Pune");
        Teacher t = new Teacher(12,"Aarti",address);
        System.out.println(t);
        Student s = new Student(12,"Shreya",address);
        System.out.println(s);
    }
}



//OUTPUT

  //  Teacher{id=12, name=Aarti, address=Address{plotno=23, houseno=457, area='Pune'}}
  //  Student{id=12, name=Shreya, address=Address{plotno=23, houseno=457, area='Pune'}}
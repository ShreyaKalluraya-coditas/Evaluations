package Evaluation3;
//Encapsulation
class Rectangle{
     private int length,breadth;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
    public void area(){
        int area = getBreadth()*getLength();
        System.out.println("Area of rectangle is "+area);
    }

    public void perimeter(){
        int perimeter = 2*(getLength()+getBreadth());
        System.out.println("Perimeter of rectangle is "+perimeter);
    }

}



public class Que1Rectangle {

    public static void main(String[] args){
        Rectangle rect = new Rectangle();
        rect.setLength(3);
        rect.setBreadth(7);
        rect.area();
        rect.perimeter();
    }
}

//OUTPUT
//Area of rectangle is 21
//        Perimeter of rectangle is 20
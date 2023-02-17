package Evaluation3;

interface Test{
    void Square();
}
class ArithmeticClass implements Test{


    @Override
    public void Square() {
        System.out.println("This is a Square");
    }
}



public class Que3Test {
    public static void main(String[] args){
        ArithmeticClass ac = new ArithmeticClass();
        ac.Square();
    }
}

//OUTPUT
//This is a Square
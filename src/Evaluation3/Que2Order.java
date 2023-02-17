package Evaluation3;
abstract class Order{
     public abstract void Display();
     public abstract void Accept();

}

class PurchaseOrder extends Order{

    String customerName,Description;

    @Override
    public void Display() {
       System.out.println("Name of customer is "+customerName);

    }

    @Override
    public void Accept() {
        System.out.println("Description of order is "+Description);
    }

}

class SalesOrder extends Order{
  String vendorName,Description;



    @Override
    public void Display() {
        System.out.println("Name of vendor is "+vendorName);
    }

    @Override
    public void Accept() {
        System.out.println("Products given by vendor is  "+Description);
    }
}





public class Que2Order {
    public static void main(String[] args){

        PurchaseOrder po = new PurchaseOrder();
        po.customerName="Shreya";
        po.Description="Pen";
        po.Display();
        po.Accept();
        PurchaseOrder p1 = new PurchaseOrder();
        p1.customerName="Krati";
        p1.Description="Copy";
        p1.Display();
        p1.Accept();
        PurchaseOrder p2 = new PurchaseOrder();
        p2.customerName="Mrunmai";
        p2.Description="Pencil";
        p2.Display();
        p2.Accept();




        SalesOrder so = new SalesOrder();
        so.vendorName="Aarti";
        so.Description="Pen Provided";
        so.Display();
        so.Accept();
        SalesOrder s1 = new SalesOrder();
        s1.vendorName="Yash";
        s1.Description="Copy Provided";
        s1.Display();
        s1.Accept();
        SalesOrder s2 = new SalesOrder();
        s2.vendorName="Aniket";
        s2.Description="Pencil Provided";
        s2.Display();
        s2.Accept();


    }
}
//OUTPUT
//Name of customer is Shreya
//        Description of order is Pen
//        Name of customer is Krati
//        Description of order is Copy
//        Name of customer is Mrunmai
//        Description of order is Pencil
//        Name of vendor is Aarti
//        Products given by vendor is  Pen Provided
//        Name of vendor is Yash
//        Products given by vendor is  Copy Provided
//        Name of vendor is Aniket
//        Products given by vendor is  Pencil Provided
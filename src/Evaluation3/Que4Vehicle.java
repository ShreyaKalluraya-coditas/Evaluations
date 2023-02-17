package Evaluation3;
import java.util.Scanner;
class Vehicle{
    String Company;
    int Price;
    Vehicle(String Company,int Price){
        this.Company=Company;
        this.Price=Price;
    }

}
class LightMotorVehicle extends Vehicle{

    int mileage;
    LightMotorVehicle(String Company, int Price,int mielage) {
        super(Company, Price);
        this.mileage=mielage;
        System.out.println("Company is "+Company+"Price is "+Price+"Mielage is"+mielage);

    }
}

class HeavyMotorVehicle extends Vehicle{
   int capacity;

    HeavyMotorVehicle(String Company, int Price,int capacity) {
        super(Company, Price);
        this.capacity = capacity;
        System.out.println("Company is "+Company+"Price is "+Price+"Capacity is"+capacity);
    }
}

public class Que4Vehicle {
   public static void main(String[] args){
       Vehicle[] v = new Vehicle[10];
       Scanner s = new Scanner(System.in);
       for(int i=0;i<10;i++){
           System.out.println("Enter you choiucs 1 is for lightVehicle and 2 is for Heavy Vehicle");
           int choices = s.nextInt();
           if(choices ==1){
               v[i]=new LightMotorVehicle("Yamaha",12345,678);
           }
           if(choices ==2){
               v[i]= new HeavyMotorVehicle("Eon",3556,89);
           }
       }

   }

}
//OUTPUT

  //  Enter you choiucs 1 is for lightVehicle and 2 is for Heavy Vehicle
//        1
//        Company is YamahaPrice is 12345Mielage is678
//        Enter you choiucs 1 is for lightVehicle and 2 is for Heavy Vehicle
//        2
//        Company is EonPrice is 3556Capacity is89
//        Enter you choiucs 1 is for lightVehicle and 2 is for Heavy Vehicle

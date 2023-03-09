package evaluation5;

public class DisplayAllUser extends NewConnection {
    public void displayUser(){
        for(NewConnection c1: connection){
            System.out.println("name='" + c1.name + '\'' +
                    ", email='" + c1.email + '\'' +
                    ", address='" + c1.address + '\'' +
                    ", aadhar='" + c1.aadhar + '\'' +
                    ", simtype='" + c1.simtype + '\'' +
                    ", initial Balance=" + c1.initialBalance +
                    ", month=" + c1.month +
                    ", mobilno=" + c1.mobilno);




        }
    }
}

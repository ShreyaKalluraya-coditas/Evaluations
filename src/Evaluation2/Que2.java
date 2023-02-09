package Evaluation2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Que2 {
    public static void main(String args[]){
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dow =currentDate.getDayOfWeek();
       System.out.println(dow);

           String e= dow.toString().toUpperCase();
        switch(e){
            case "MONDAY":
               System.out.println("Its a start of Week");
               break;
            case "TUESDAY":
                System.out.println("Its a second day of Week");
                break;
            case "WEDNESDAY":
                System.out.println("Its a third day of Week");
                break;
            case "THURSDAY":
                System.out.println("Its a fourth day of Week");
                break;
            case "FRIDAY":
                System.out.println("Yay!!! Its a last day of week .....enjoy your weekend");
                break;
            case "SATURDAY":
                System.out.println("Its a Weekend!!majani life :)");
                break;
            case "SUNDAY":
                System.out.println("Last day of weekend :( ");
                break;

        }

        String Days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
      //  Date d = new Date();
       //int  todaydate = d.getDate();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

       for(int i=0;i<Days.length;i++){

           if(i==day-1)
               continue;

           System.out.println(Days[i]);

       }





    }
}

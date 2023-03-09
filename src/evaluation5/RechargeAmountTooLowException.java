package evaluation5;

public class RechargeAmountTooLowException extends Exception{
    RechargeAmountTooLowException(String s){
        System.out.println("Recharge amount should be greater "+s);
    }
}

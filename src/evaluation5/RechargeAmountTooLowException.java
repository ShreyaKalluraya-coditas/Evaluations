package evaluation5;

public class RechargeAmountTooLowException extends  RuntimeException{
    RechargeAmountTooLowException(String s){
        System.out.println("Recharge amount should be greater "+s);
    }
}

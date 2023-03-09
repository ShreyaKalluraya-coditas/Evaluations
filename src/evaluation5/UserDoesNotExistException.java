package evaluation5;

public class UserDoesNotExistException extends Exception{
    UserDoesNotExistException(String s){
        System.out.println("The mobile number is not registered"+s);
    }
}

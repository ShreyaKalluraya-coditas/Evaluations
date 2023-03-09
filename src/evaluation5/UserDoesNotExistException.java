package evaluation5;

public class UserDoesNotExistException extends RuntimeException{
    UserDoesNotExistException(String s){
        System.out.println("The mobile number is not registered"+s);
    }
}

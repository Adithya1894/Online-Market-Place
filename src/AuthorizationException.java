// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

//Distributed Exception handling class to throw exceptions at runtime, if the required role is not found while
//accessing a method, this exception is throw
public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String methodName) {
        //gets the name of the method for which, the access is denied and throws this exception
        super("Invalid Authorization - Access Denined to " + methodName + "() function!");
    }
}

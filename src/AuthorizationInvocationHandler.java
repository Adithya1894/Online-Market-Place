// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


/**
 *
 * @author adithyamorampudi
 */
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

//AuthorizationInvocationHandler class to determine the RBAC
public class AuthorizationInvocationHandler implements InvocationHandler, Serializable {
    //private instance of the Object class
    private Object objectImpl;

    //constructor which initializes the instance of Object
    public AuthorizationInvocationHandler(Object impl) throws RemoteException{
        this.objectImpl = impl;
    }

    //invoker which is responsible for invoking the method if required role is found
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //checks if there is any annotation present on the specified Interface
        if (method.isAnnotationPresent(RequiresRole.class)) {
            RequiresRole test = method.getAnnotation(RequiresRole.class);
            Session session = (Session) args[0];

            //checks if the session object contains the same type of role required by the requested method
            if (session.getUser().getRoleType().equals(test.value())) {
                //if it is true then the method is invoked
                return method.invoke(objectImpl, args);
            } else {
                throw new AuthorizationException(method.getName());
            }
        } else {
            return method.invoke(objectImpl, args);
        }
    }
}

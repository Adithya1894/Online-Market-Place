// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

// Ryan: Please include useful comments in each file.
//fixed
public class UserFactory extends AbstractFactory{



    @Override
    Admin getAdmin(String admin) {
        return null;
    }

    //returns the user view when requested by the user.
    @Override
    User getUser(String user) {


        //if the value of the user string is null, then the getUser method returns null
        if(user == null)
            return null;

        //if the user string contains the value "USER" then it return the ConcreteUser
        if(user.equalsIgnoreCase("USER"))

            return new ConcreteUser();
        //returns null by default.
        return null;
    }
}

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



        if(user == null)
            return null;

        if(user.equalsIgnoreCase("USER"))

            return new ConcreteUser();

        return null;
    }
}

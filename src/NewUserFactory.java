// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


public class NewUserFactory extends AbstractFactory {

    //This method returns null since we don't need admin object in newUser
    @Override
    Admin getAdmin(String admin) {
        return null;
    }

    //this method returns null since we don't need user object in newUser
    @Override
    User getUser(String user) {
        return null;
    }

    /**
     * This method returns the object of ConcreteNewUser to display the welcome message.
     * @param user
     * @return
     */
    @Override
    NewUser getNewUser(String user) {
        if(user == null)
            return null;
        //if admin equals Admin then object of concrete admin is created
        if(user.equalsIgnoreCase("newUser")) {
            return new ConcreteNewUser();

        }
        return null;
    }
}


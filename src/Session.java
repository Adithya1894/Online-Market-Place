// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

/**
 * Session class holds the details about the session object
 */

import java.io.Serializable;

public class Session implements Serializable{

    //Creating a private instance of the Role class to get the role of the user
    private  Role role;

    //Instantiating the Role class to get his role
    public Session(String userRole, String userName)
    {
        this.role = new Role(userRole, userName);
    }

    //returns the role of the user. this is being used by reflection in this application so far
    public Role getUser() {

        return role;
    }

}

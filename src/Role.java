// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

/**
 * ROle class to get the role of the user
 */

import java.io.Serializable;

//this class is used to get the user role
public class Role implements Serializable{


    //private fields
    private String userRole, userName, firstName;


    public Role(String userRole, String userName)
    {
        this.userRole=userRole;
        this.userName = userName;
    }

    //returns the user role
    public String getRoleType(){

        return userRole;
    }
    //returns the user name
    public String getUserName() {
        return userName;
    }

    //returns the user firstName, this method is not yet implemented.
    public String getFirstName() {
        return firstName;
    }
}

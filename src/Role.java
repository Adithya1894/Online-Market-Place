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


    private String userRole, userName;


    public Role(String userRole, String userName)
    {
        this.userRole=userRole;
        this.userName = userName;
    }

    //returns the user role
    public String getRoleType(){

        return userRole;
    }

    public String getUserName() {
        return userName;
    }
}

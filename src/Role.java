// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.io.Serializable;

public class Role implements Serializable{


    private String userRole;

    public Role(String userRole)
    {
        this.userRole=userRole;
    }

    public String getRoleType(){

        return userRole;
    }
}

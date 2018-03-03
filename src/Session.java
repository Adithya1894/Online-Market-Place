// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.io.Serializable;

public class Session implements Serializable{


    private  Role role;

    public Session(String userRole)
    {
        this.role = new Role(userRole);
    }


    public Role getUser() {

        return role;
    }

}

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

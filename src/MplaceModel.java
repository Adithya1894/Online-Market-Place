
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.rmi.RemoteException;
public class MplaceModel {



    private String username;
    private String userpass;
    private String adminId;
    private String adminPass;

    public MplaceModel() throws RemoteException{

        username = "amorampu";
        userpass = "1234";
        adminId = "admin";
        adminPass = "12345";


    }

     boolean loginUser(String uname, String pass) {

         if (this.username.equals(uname) && this.userpass.equals(pass))

             return true;

         else {
             return false;
         }
     }

     boolean loginAdmin(String adminId, String adminPass) {
         //System.out.println(adminId +" "+adminPass);
         if (this.adminId.equals(adminId) && this.adminPass.equals(adminPass))
         {

             return true;
         }
         else {
             return false;
         }
     }


}
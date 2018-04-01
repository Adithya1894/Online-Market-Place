
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.rmi.RemoteException;
public class MplaceModel {

	// Ryan: Please include useful comments in each file.
    //fixed
    //private fields so, other classes cannot access these fields
    private String username;
    private String userpass;
    private String adminId;
    private String adminPass;

    public MplaceModel() throws RemoteException{

        //initializing the variables
        username = "amorampu";
        userpass = "1234";
        adminId = "admin";
        adminPass = "12345";


    }

     boolean loginUser(String uname, String pass) {

        //making a comparison to check if the entered username equals the initialized one
         if (this.username.equals(uname) && this.userpass.equals(pass))

             return true;

         else {
             return false;
         }
     }

     //Athentication for admin
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
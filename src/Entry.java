// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.util.Scanner;

public class Entry {

    /**
     * private variables to store the values of the user names and password of both Admin and Customer
     */
    private int type;

    private String adminUserId;

    private String adminPass;

    private String userId;

    private String pass;

    //private Session session = null;


	// Ryan: Shouldn't this have a scope associated with it?
    //Fixed: added the scope to the variable.
    private Scanner sc = new Scanner(System.in);

    /**
     * login method which takes the information from the user about the type of user and his details
     * control goes back to client controller, from there it goes to front controller and from front
     * controller, the values go to client controller and this passes and authenticates
     * @return
     */
    public String login() {

          System.out.println(" Enter 1 for Admin Login");
          System.out.println(" Enter 2 for Customer Login");
          System.out.println("Enter your choice: ");

          type = Integer.parseInt(sc.nextLine());

          if(type == 1){

              return "Admin";
          }
          else if(type == 2) {
              return "User";
          }
          return "false";

}

    /**
     * This takes the values for admin login
     */
    public  void adminLogin(){


        System.out.println("Enter your userID: ");

        adminUserId = sc.nextLine();

        System.out.println("Enter your password: ");

        adminPass = sc.nextLine();

    }

    /**
     * This takes the values of Customer Login
     */
    public void customerLogin(){

        System.out.println("Enter your userID: ");

        userId = sc.nextLine();

        System.out.println("Enter your password: ");

        pass = sc.nextLine();


    }

    /**
     * getter methods to access the values
     * @return
     */
    public String getAdminUserId() {
        return adminUserId;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }


}

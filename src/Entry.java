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

    //these fields are for user Registration.
    private String firstName, lastName, userName, password;

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
          System.out.println(" Enter 3 for Customer Registration");
          System.out.println("Enter your choice: ");

          type = Integer.parseInt(sc.nextLine());

          if(type == 1){

              return "Admin";
          }
          else if(type == 2) {
              return "User";
          }
          else if(type == 3){
              return "newUser";
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
     * This method is responsible to take the user details and store them in the database.
     */
    public void customerRegistration(){



        //Taking the input from the command Line.
        System.out.println("Enter the First Name: ");

        firstName = sc.nextLine();

        System.out.println("Enter the Last Name: ");

        lastName = sc.nextLine();

        System.out.println("Enter the User Name: ");

        userName = sc.nextLine();

        System.out.println("Enter the password: ");

        password = sc.nextLine();

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


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

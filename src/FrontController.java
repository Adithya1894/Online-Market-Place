// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class FrontController {

    //private variable of type Dispatcher
    private Dispatcher dispatcher;

	// Ryan: Shouldn't this have a scope associated with it?
	//Fixed: added the scope to the session
    //Session variable and assigning it to null
    private Session session = null;
    private Client_Controller cc_obj = new Client_Controller();

    //object of Entry to get the login details
    private Entry entry = new Entry();

    /**
     * creating the object of Dispatcher class
     *
     */
    public FrontController(){

        dispatcher = new Dispatcher();
    }

    /**
     * gets the required view it wants to show from dispatchRequest method of this class
     * @param view
     * @return
     */
    private boolean isAuthenticUser(String view) {

        if (view.equalsIgnoreCase("Admin")) {
            entry.adminLogin();
            //getting the values from the entry point.
            String id = entry.getAdminUserId();
            String pass = entry.getAdminPass();

            //control goes to client controller to verify the login
            if(cc_obj.loginAdmin(id, pass)){
            //if the login is successful, then it creates a sesison obejct
                session = cc_obj.processLogin("Admin");
                return true;
            }
        }else if(view.equalsIgnoreCase("User"))
        {

            entry.customerLogin();
            //getting the values of user Id and Password from the entry point file
            String id = entry.getUserId();
            String pass = entry.getPass();
            //control goes to client controller to verify the login
            if(cc_obj.loginUser(id, pass)){
                //if the login is successful, then it creates a sesison obejct
                session = cc_obj.processLogin("User");
                return true;
            }
        }

        //checking if the required view is a new user view
        else if(view.equalsIgnoreCase("newUser")){
            //calling registration method to get the login details
            entry.customerRegistration();

            String firstName, lastName, userName, password;

            firstName = entry.getFirstName();

            lastName = entry.getLastName();

            userName = entry.getUserName();

            password = entry.getPassword();



            if(cc_obj.isUserRegistered(firstName, lastName, userName, password)){
                session = cc_obj.processLogin("newUser");
                  return true;
            }

        }

        return false;
    }

    /**
     * dispatches the view based upon the login and required view
     * @param view
     */
    public void dispatchRequest(String view){

        //if the user is authenticated, then it dispatchs the respected view.
        if(isAuthenticUser(view)){
            dispatcher.dispatch(view, session);
        }//if the user is not authenticated, then it dispatches the error view
        else {
            dispatcher.dispatch_error("Error");
        }
    }



}

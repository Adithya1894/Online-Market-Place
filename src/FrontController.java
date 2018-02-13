// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class FrontController {

    private Dispatcher dispatcher;

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

        Client_Controller cc_obj = new Client_Controller();

        //object of Entry to get the login details
        Entry ep = new Entry();


        if (view.equalsIgnoreCase("Admin")) {
            ep.adminLogin();
            String id = ep.getAdminUserId();
            String pass = ep.getAdminPass();
            //control goes to client controller to verify the login
            return cc_obj.loginAdmin(id, pass);
        }else if(view.equalsIgnoreCase("User"))
        {

            ep.customerLogin();
            String id = ep.getUserId();
            String pass = ep.getPass();
            //control goes to client controller to verify the login
            return cc_obj.loginUser(id, pass);
        }

        return false;
    }


    /**
     * dispatches the view based upon the login and required view
     * @param view
     */
    public void dispatchRequest(String view){


        if(isAuthenticUser(view)){
            dispatcher.dispatch(view);
        }
        else {
            dispatcher.dispatch_error("Error");
        }
    }



}

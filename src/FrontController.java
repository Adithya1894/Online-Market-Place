// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class FrontController {

    private Dispatcher dispatcher;


    public FrontController(){
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticUser(String view) {

        Client_Controller cc_obj = new Client_Controller();

        Entry ep = new Entry();


        if (view.equalsIgnoreCase("Admin")) {
            ep.adminLogin();
            String id = ep.getAdminUserId();
            String pass = ep.getAdminPass();
            return cc_obj.loginAdmin(id, pass);
        }else if(view.equalsIgnoreCase("User"))
        {
            ep.customerLogin();
            String id = ep.getUserId();
            String pass = ep.getPass();

            return cc_obj.loginUser(id, pass);
        }

        return false;
    }



    public void dispatchRequest(String view){


        if(isAuthenticUser(view)){
            dispatcher.dispatch(view);
        }
        else {
            dispatcher.dispatch_error("Error");
        }
    }



}

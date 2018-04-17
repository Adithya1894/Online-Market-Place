

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class Client_Controller {
	
	// Ryan: Why are these static here?
    //Fixed: moved the variables to the static method instead of global access
    //MplaceInterface is static because we are accessing it in the main method. which is static
    //creating the static objects
    static MPlaceInterface object;
    Session session = null;


//Interacts with the controller on the server side.
//just prints a welcome message when the client is connected to server
    public static String printHello() {



        String val = "";
        try {
            //remote call
             val =  object.hello();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return val;

    }

    /**
     * ProcessLogin Method for making the RBAC work
     * @param userType
     * @return
     */
    public  Session processLogin(String userType, String userName){

        try {
            session = object.processLogin(userType, userName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return session;
    }



    /**
     * takes the uname and password from the frontController and passes them to the server
     * makes a remote call and then if it is validated, then returns true and control
     * goes back to front controller
     * @param uname
     * @param pass
     * @return
     */
    public static boolean loginAdmin(String uname, String pass){
        //boolean, which stores the returned value from remote call
        boolean val = false;


        try{
            //remote call
            val = object.loginAdmin(uname, pass);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return val;
    }

    /**
     * Customer Login
     *
     * Takes the user name and password from the frontController and passes them to the server
     * makes a remote call and then if it is validated, then returns true and control
     * goes back to front controller
     * @param uname
     * @param pass
     * @return
     */
    public static boolean loginUser(String uname, String pass){
        boolean val = false;
        try{
            //remote call
            val = object.loginUser(uname, pass);

        }catch(RemoteException e){
            e.printStackTrace();
        }

        return val;
    }


    /**
     * Method to browse Admin Items.
     * @param session
     * @return
     */

    public static String[] browseAdminItems(Session session){

        String[] val = {" "};
        try {
            val = object.browsingAdmin(session);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        return val;
    }

    //Gets the list of products from the database.
    public static List<String> browseUserItems(Session session){

        List<String> val = new ArrayList<>();
        try {
            //returns a List of Strings and stored in the val variable.
            val = object.browsingUser(session);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        return val;
    }

    //takes the items from the Admin and adds it into the database.
    public static boolean add(Session session, String[] val){

        boolean status;

        try {
            //returns a boolean value to show the status of the addition of product
            status = object.addItems(session,val);
            if(status)
                return status;

            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return false;
    }


    //calling the purchase items method on the server side
    public static boolean purchaseItems(Session session, int id){

        boolean status = false;
        try{
            //purchase function at the server returns true if purchase is made.
          status = object.purchase(session,id);
        }catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return status;
    }

    //calling the remove item method on the server side.
    public static boolean removeProduct(Session session, int itemId){
        //trying to connect to the server and access the removeProducts method
        try{
            //if item removed then the return value is true.d
            if(object.removeProduct(session, itemId))
                return true;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        //if item is not removed then item value is not removed and return false.
        return false;
    }

    //returns true if the new user is registered into the system
    public static boolean isUserRegistered(String firstName, String lastName, String userName, String password){

        try {
            if(object.registration(firstName, lastName, userName, password))
                System.out.println("success");
                return true;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        System.out.println("failure");

        return false;
    }

    /**
     * This method is used to add new customers into the database, this can only be done by admin
     * @param session
     * @param customerDetails
     * @return
     */
    public static boolean addNewCustomer(Session session, String[] customerDetails){

        boolean status;

        try {
            //returns a boolean value to show the status of the addition of customer
            status = object.adNewCustomer(session,customerDetails);
            if(status)
                return status;

            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This method is used to add new Admin into the database, this can only be done by Admin
     * @param session
     * @param adminDetails
     * @return
     */
    public static boolean addNewAdmin(Session session, String[] adminDetails){
        boolean status;

        try {
            //returns a boolean value to show the status of the addition of new Admin
            status = object.addNewAdmin(session,adminDetails);
            if(status)
                return status;

            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This method is used to remove customers from the database
     * @param session
     * @param userId
     * @return
     */
    public static boolean removeCustomer(Session session, int userId){
        //trying to connect to the server and access the removeProducts method
        try{
            //if customer is removed then the return value is true.d
            if(object.removeCustomer(session, userId))
                return true;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        //if customer is not removed then item value is not removed and return false.
        return false;
    }

    /**
     * This method is used to list all the customers in the database
     * @param session
     * @return
     */
    public List<String> listAllCustomers(Session session){

        List<String> allCustomers = new ArrayList<>();
        try {
            //returns a List of Strings and stored in the val variable.
            allCustomers = object.listAllCustomers(session);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        return allCustomers;
    }

    /**
     *Main method of the controller
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
        //security manager
        System.setSecurityManager(new SecurityManager());
        //variables of type FrontController and Entry
        FrontController fc;
        Entry ep;

        //Creating an object of the class view to call the methods present in the view

        Client_View obj =  new Client_View();

        //Accessing the front controller
        fc = new FrontController();

        //accessing the initial view of the project
        ep = new Entry();


        try{
            //storing the location of the server in the string format
            String name1 = "//10.234.136.55:1895/server";
            //lookup function to find the desired service from the registry
            object =  (MPlaceInterface) Naming.lookup(name1);

    		printHello();

    		obj.print();

    		System.out.println();


            //requesting the view based on the input from the client
            fc.dispatchRequest(ep.login());


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}

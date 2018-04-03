

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServerController extends UnicastRemoteObject implements MPlaceInterface {

    //creating an object of MplaceModel to access its methods and properties
    private  MplaceModel obj = new MplaceModel();





    //private String name;

    public ServerController() throws RemoteException{
        super();


    }


    /**
     * Registration method, this is currently not implemented
     * @param session
     * @param firstName
     * @param lastName
     * @param userName
     * @param email
     * @param password
     * @throws RemoteException
     */
    @Override
    public void registration(Session session, String firstName, String lastName, String userName, String email, String password) throws RemoteException {

    }

    /**
     * Login method for admin, This method gets the login credentials from the client and verifies it with the model
     * @param userName
     * @param password
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean loginAdmin(String userName, String password) throws RemoteException {
        boolean adminValue;

        //calling the model to find if the user is legitimate
        adminValue = obj.loginAdmin(userName, password);

        //System.out.println(adminValue);

        return adminValue;
    }

    /**
     *login user method to log users into the system, takes the credentials as parameters.
     * @param userName
     * @param password
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean loginUser(String userName, String password) throws RemoteException {

        boolean value;

        //calling the loginUser method in the model
        value = obj.loginUser(userName, password);

        return value;

    }

    @Override
    public String[] browsingAdmin(Session session) throws RemoteException {
        return new String[0];
    }

    /**
     * Add items method to add items into the database, this is only accessible to admin
     * This method is synchronized
     * @param session
     * @param items
     * @return
     * @throws RemoteException
     */
    @Override
    public synchronized boolean addItems(Session session, String[] items) throws RemoteException{

        //calling the addItems method in the model
       boolean val = obj.addItems(items);

       return val;
    }

    //
    //function which displays all the available products to the user.
    @Override
    public List<String> browsingUser(Session session) throws RemoteException {

        List<String> list;

        //calling the browsingUser method in the model.
        list = obj.browsingUser();

        return list;

    }

    @Override
    public void update(Session session, int itemId) throws RemoteException {

    }

    @Override
    public void remove(Session session, int itemId) throws RemoteException {

    }

    /**
     * This method is only accessible to User and this is used to purchase items
     * takes a session object and item id as parameters
     * @param session
     * @param itemId
     * @return
     * @throws RemoteException
     */
    @Override
    public synchronized boolean purchase(Session session, int itemId) throws RemoteException {

        //calling the purchase method in the model
        boolean val = obj.purchase(itemId);

        //boolean value
        return val;

    }

    @Override
    public String hello() throws RemoteException {

        String hello = "welcome to MarketPlace Application";
        return hello;
    }

    /**
     * checks the login and creates a session object and returns it.
     * @param userType
     * @return
     * @throws RemoteException
     */
    @Override
    public Session processLogin(String userType) throws RemoteException {
        Session session = new Session(userType);
        return session;
    }


    /**
     *
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        System.setSecurityManager(new SecurityManager());

        try{

            //Naming our server so that it can be binded to the registry
            String name = "//10.234.136.55:1895/server";

            //creating the proxy
            MPlaceInterface stub = (MPlaceInterface) Proxy.newProxyInstance(MPlaceInterface.class.getClassLoader(),
                    new Class<?>[] {MPlaceInterface.class},
                    new AuthorizationInvocationHandler(new ServerController()));



            //object of the controller class which is MplaceModel
            //ServerController stub = new ServerController(name);
            //binding the server
            Naming.rebind(name, stub);

            System.out.println("Server Started");


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }


}

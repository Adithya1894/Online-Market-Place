

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


public class ServerController extends UnicastRemoteObject implements MPlaceInterface {

    private  MplaceModel obj = new MplaceModel();;

    //private String name;

    public ServerController() throws RemoteException{
        super();
        //name = m;
    }


    @Override
    public void registration(Session session, String firstName, String lastName, String userName, String email, String password) throws RemoteException {

    }

    @Override
    public boolean loginAdmin(Session session, String userName, String password) throws RemoteException {
        boolean adminValue;

        adminValue = obj.loginAdmin(userName, password);

        //System.out.println(adminValue);

        return adminValue;
    }

    @Override
    public boolean loginUser(Session session, String userName, String password) throws RemoteException {

        boolean value;

        value = obj.loginUser(userName, password);

        return value;

    }

    @Override
    public String[] browsingAdmin(Session session) throws RemoteException {
        return new String[0];
    }

    @Override
    public String[] browsingUser(Session session) throws RemoteException {
        return new String[0];
    }

    @Override
    public void update(Session session, int itemId) throws RemoteException {

    }

    @Override
    public void remove(Session session, int itemId) throws RemoteException {

    }

    @Override
    public void purchase(Session session, int itemId) throws RemoteException {

    }

    @Override
    public String hello() throws RemoteException {

        String hello = "welcome to RMI";
        return hello;
    }

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
            String name = "//10.234.136.57:1895/server";


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

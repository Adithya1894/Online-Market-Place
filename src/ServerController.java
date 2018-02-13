

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServerController extends UnicastRemoteObject implements MPlaceInterface {

    private  MplaceModel obj = new MplaceModel();;

    private String name;

    public ServerController(String m) throws RemoteException{
        super();
        name = m;
    }


    @Override
    public void registration(String firstName, String lastName, String userName, String email, String password) throws RemoteException {

    }

    @Override
    public boolean loginAdmin(String userName, String password) throws RemoteException {
        boolean adminValue;

        adminValue = obj.loginAdmin(userName, password);

        //System.out.println(adminValue);

        return adminValue;
    }

    @Override
    public boolean loginUser(String userName, String password) throws RemoteException {

        boolean value;

        value = obj.loginUser(userName, password);

        return value;

    }

    @Override
    public String[] browsingAdmin() throws RemoteException {
        return new String[0];
    }

    @Override
    public String[] browsingUser() throws RemoteException {
        return new String[0];
    }

    @Override
    public void update(int itemId) throws RemoteException {

    }

    @Override
    public void remove(int itemId) throws RemoteException {

    }

    @Override
    public void purchase(int itemId) throws RemoteException {

    }

    @Override
    public String hello() throws RemoteException {

        String hello = "welcome to RMI";
        return hello;
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

            //object of the controller class which is MplaceModel
             ServerController stub = new ServerController(name);
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

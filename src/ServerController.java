

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

    private  MplaceModel obj = new MplaceModel();

    ResultSet resultSet = null;


    //private String name;

    public ServerController() throws RemoteException{
        super();
        //name = m;
    }


    @Override
    public void registration(Session session, String firstName, String lastName, String userName, String email, String password) throws RemoteException {

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
    public String[] browsingAdmin(Session session) throws RemoteException {
        return new String[0];
    }

    @Override
    public List<String> browsingUser(Session session) throws RemoteException {


        //Creating a new arrayList to add the items and return it to the Client
        List<String> itemList=new ArrayList<>();
        String data;
        int i=0;

        DbConnection dbConnection = new DbConnection();

        //checking if the connection is established
        if(dbConnection.setConnectionEstablished()){

            try {

               resultSet = dbConnection.getResultSet();
                while(resultSet.next())
                {
                    data=resultSet.getString("item_id")+","+resultSet.getString("item_price")+","+resultSet.getString("item_stock")+","+resultSet.getString("item_name")+","+resultSet.getString("item_description");
                    //adding the items into the arrayList
                    itemList.add(i,data);
                    i++;
                }

                return itemList;

            }catch (SQLException e){

                System.out.println("cannot get the result!");

            }



        }




        return null;
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
            String name = "//10.234.136.55:1895/server";


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



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

    DbConnection dbConnection;



    //private String name;

    public ServerController() throws RemoteException{
        super();

        //creating the object of the DbConnection class.
        dbConnection = new DbConnection();
        //setting the connection
        dbConnection.setConnectionEstablished();
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
    public boolean addItems(Session session, String[] items) throws RemoteException{

        //boolean variable to determine the status of the add item query.
        boolean status;

        if(items!=null){

            //calling the addItems method to add the item into the database.
               status = dbConnection.addItems(items);

               if(status){
                   return true;
               }

               return false;


        }

        return false;
    }


    //function which displays all the available products to the user.
    @Override
    public synchronized List<String> browsingUser(Session session) throws RemoteException {


        //Creating a new arrayList to add the items and return it to the Client
        List<String> itemList=new ArrayList<>();
        String data;
        int i=0;

        //careating a new object of the DbConnection class

        //checking if the connection is established
        if(dbConnection.isConnectionEstablished()){

            try {

               resultSet = dbConnection.getResultSet();
                while(resultSet.next())
                {
                    //getting the result from the database using the DbConnection class
                    data=resultSet.getString("item_id")+","+resultSet.getString("item_name")+","+resultSet.getString("item_stock")+","+resultSet.getString("item_price")+","+resultSet.getString("item_description");
                    //adding the items into the arrayList
                    itemList.add(i,data);
                    i++;
                }

                return itemList;

                //catching the sql exception
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
    public synchronized boolean purchase(Session session, int itemId) throws RemoteException {


        ResultSet resultSet = null;
        int stock = 0;

        if(dbConnection.isConnectionEstablished()){
            try{
                resultSet = dbConnection.getUniqueItem(itemId);
                while(resultSet.next())
                {
                    stock=Integer.parseInt(resultSet.getString("item_stock").toString());

                    System.out.println(stock);
                }
                resultSet.beforeFirst();


                while(resultSet.next())
                {
                    if(!(stock<=0)){
                        //reduce the stock by 1 after purchase

                        System.out.println("before substraction"+stock);

                        stock=stock-1;

                        System.out.println(stock);
                        //calling the database
                        if(dbConnection.purchaseItems(itemId, stock));
                        {
                            //System.out.println(val);
                            //if success returns true
                            return true;
                        }
                    }
                    else{
                        return false;
                    }
                }
                System.out.println("Hello bug");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
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

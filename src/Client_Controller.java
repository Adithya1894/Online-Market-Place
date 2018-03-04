

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client_Controller {

    //creating the static objects
    static MPlaceInterface object;
    static FrontController fc;
    static Entry ep;
    static Session session = null;


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

    public static Session processLogin(String userType){

        try {
            session = object.processLogin(userType);
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
    public static boolean loginAdmin(Session session,String uname, String pass){
        //boolean, which stores the returned value from remote call
        boolean val = false;


        try{
            //remote call
            val = object.loginAdmin(session, uname, pass);
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
    public static boolean loginUser(Session session, String uname, String pass){
        boolean val = false;
        try{
            //remote call
            val = object.loginUser(session, uname, pass);

        }catch(RemoteException e){
            e.printStackTrace();
        }

        return val;
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

        //Creating an object of the class view to call the methods present in the view

        Client_View obj =  new Client_View();




        //Accessing the front controller
        fc = new FrontController();

        //accessing the initial view of the project
        ep = new Entry();






        try{
            //storing the location of the server in the string format
            String name1 = "//10.234.136.57:1895/server";
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

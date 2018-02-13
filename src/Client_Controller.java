

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

    static MPlaceInterface object;
    static FrontController fc;
    static Entry ep;



//Interacts with the controller on the server side.

    public static String printHello() {

        //obj.print();

        String val = "";
        try {
             val =  object.hello();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return val;

    }

    public static boolean loginAdmin(String uname, String pass){

        boolean val = false;

        //System.out.println(uname + " " +pass);
        try{
            val = object.loginAdmin(uname, pass);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return val;
    }

    public static boolean loginUser(String uname, String pass){
        boolean val = false;
        try{
            val = object.loginUser(uname, pass);

        }catch(RemoteException e){
            e.printStackTrace();
        }

        return val;
    }






    /**
     *
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{

        System.setSecurityManager(new SecurityManager());
        //Creating an object of the class view to call the methods present in the view




        Client_View obj =  new Client_View();


        //obj.print();

        //Accessing the front controller
        fc = new FrontController();

        //accessing the initial view of the project
        ep = new Entry();






        try{
            //storing the location of the server in the string format
            String server = "//10.234.136.57/server";
            //lookup function to find the desired service from the registry
            object =  (MPlaceInterface) Naming.lookup(server);

    		printHello();

    		obj.print();

    		System.out.println();

            //fc.dispatchRequest("Admin");

            fc.dispatchRequest(ep.login());


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }







}

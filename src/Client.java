

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

public class Client {
    static MPlaceInterface object;

    /**
     *
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{

        System.setSecurityManager(new SecurityManager());

        try{
            //storing the location of the server in the string format
            String server = "//10.234.136.57/server";
            //lookup function to find the desired service from the registry
            object =  (MPlaceInterface) Naming.lookup(server);

            System.out.println("CLient connected to server");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}



// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MPlaceInterface extends Remote{

    /**
     *Registration method
     * @param firstName
     * @param lastName
     * @param userName
     * @param email
     * @param password
     * @throws RemoteException
     */
    @RequiresRole("User")
    void registration(Session session, String firstName, String lastName,String userName, String email, String password) throws RemoteException;

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    boolean loginAdmin(Session session, String userName, String password) throws RemoteException;

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    @RequiresRole("User")
    boolean loginUser(Session session, String userName, String password) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    //change this User role to Admin role. DONT FORGET
    @RequiresRole("Admin")
    String[] browsingAdmin(Session session) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    @RequiresRole("User")
    String[] browsingUser(Session session) throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    void update(Session session, int itemId) throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    void remove(Session session, int itemId) throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("User")
    void purchase(Session session, int itemId) throws RemoteException;
    
    String hello() throws RemoteException;


    Session processLogin(String userType) throws RemoteException;


}

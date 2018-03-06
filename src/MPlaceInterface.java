

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
     * Added annotations for Role based access control
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
    //@RequiresRole("Admin")
    boolean loginAdmin(String userName, String password) throws RemoteException;

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    //@RequiresRole("User")
    boolean loginUser(String userName, String password) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    //changed this User role to Admin role.
    @RequiresRole("Admin")
    String[] browsingAdmin(Session session) throws RemoteException;

    /**
     *Added annotation for role based access control
     * @return
     * @throws RemoteException
     */
    @RequiresRole("User")
    String[] browsingUser(Session session) throws RemoteException;

    /**
     *added annotation for role based access control
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    void update(Session session, int itemId) throws RemoteException;

    /**
     *added annotation for role based access control
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    void remove(Session session, int itemId) throws RemoteException;

    /**
     *added annotation for role based access control
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("User")
    void purchase(Session session, int itemId) throws RemoteException;
    
    String hello() throws RemoteException;

    //ProcessLogin method is invoked, whenever a user is authenticated to create a session object and return it
    Session processLogin(String userType) throws RemoteException;


}

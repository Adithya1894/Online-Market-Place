

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MPlaceInterface extends Remote{

    /**
     * Added annotations for Role based access control
     *Registration method
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @throws RemoteException
     */
    //@RequiresRole("User")
    boolean registration(String firstName, String lastName,String userName, String password) throws RemoteException;

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
     * Used by admin to add the products into the database.
     * @param session
     * @param items
     * @return
     */
    @RequiresRole("Admin")
    boolean addItems(Session session, String[] items) throws RemoteException;

    /**
     *Added annotation for role based access control
     * @return
     * @throws RemoteException
     */
    //@RequiresRole("User")
    List<String> browsingUser(Session session) throws RemoteException;

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
    boolean removeProduct(Session session, int itemId) throws RemoteException;

    /**
     *added annotation for role based access control
     * @param itemId
     * @throws RemoteException
     */
    @RequiresRole("User")
    boolean purchase(Session session, int itemId) throws RemoteException;
    
    String hello() throws RemoteException;

    //ProcessLogin method is invoked, whenever a user is authenticated to create a session object and return it
    Session processLogin(String userType, String userName) throws RemoteException;

    //method to add items into the cart for the specific user
    boolean addItemToCart(Session session, int itemId) throws RemoteException;

    /**
     * Method delete item from cart takes the session and item Id as input and deletes the item from the cart
     * of specific user
     * @param session
     * @param itemId
     * @return
     * @throws RemoteException
     */
    boolean deleteItemFromCart(Session session, int itemId) throws RemoteException;

    /**
     * Mehtod displayUserData takes the session as argument and displays the user's cart data.
     * @param session
     * @return
     * @throws RemoteException
     */
    List<String> displayUserCart(Session session) throws RemoteException;

}

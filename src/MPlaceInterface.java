

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
    List<String> purchase(Session session, int itemId) throws RemoteException;
    
    String hello() throws RemoteException;

    //ProcessLogin method is invoked, whenever a user is authenticated to create a session object and return it
    Session processLogin(String userType, String userName) throws RemoteException;

    //method to add items into the cart for the specific user
    @RequiresRole("User")
    boolean addItemToCart(Session session, int itemId, int quantity) throws RemoteException;

    /**
     * This method is only accessible to customers
     * Method delete item from cart takes the session and item Id as input and deletes the item from the cart
     * of specific user
     * @param session
     * @param itemId
     * @return
     * @throws RemoteException
     */
    @RequiresRole("User")
    boolean deleteItemFromCart(Session session, int itemId) throws RemoteException;

    /**
     * This method is only accessible to Customer
     * Mehtod displayUserData takes the session as argument and displays the user's cart data.
     * @param session
     * @return
     * @throws RemoteException
     */
    @RequiresRole("User")
    List<String> displayUserCart(Session session) throws RemoteException;

    /**
     * This method is used to add new customers into the database,
     * This is only accessible to Administrator and it takes the argument as a String array of customer details.
     * @param session
     * @param customerDetails
     * @return
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    boolean addNewCustomer(Session session, String[] customerDetails) throws RemoteException;

    /**
     * This method is used to add new admin into the database
     * This is only accessible to Administrator.
     * @param session
     * @param adminDetails
     * @return
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    boolean addNewAdmin(Session session, String[] adminDetails) throws RemoteException;

    /**
     * This method is to remove the specific user from the system
     * This method is only accessible to Administrator.
     * @param session
     * @param userId
     * @return
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    boolean removeCustomer(Session session, int userId) throws RemoteException;

    /**
     * This method is used by the Administrator to list all the registered users in the system.
     * @param session
     * @return
     * @throws RemoteException
     */
    @RequiresRole("Admin")
    List<String> listAllCustomers(Session session) throws RemoteException;

    @RequiresRole("Admin")
    boolean updateItems(Session session, int itemId, int choice, String update) throws RemoteException;
}

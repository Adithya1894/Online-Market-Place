

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
    void registration(String firstName, String lastName,String userName, String email, String password) throws RemoteException;

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    void loginAdmin(String userName, String password) throws RemoteException;

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    void loginUser(String userName, String password) throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    String[] browsingAdmin() throws RemoteException;

    /**
     *
     * @return
     * @throws RemoteException
     */
    String[] browsingUser() throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    void update(int itemId) throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    void remove(int itemId) throws RemoteException;

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    void purchase(int itemId) throws RemoteException;


}

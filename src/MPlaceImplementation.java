
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MPlaceImplementation extends UnicastRemoteObject implements MPlaceInterface{



    private String name;

    public MPlaceImplementation(String m) throws RemoteException{
        super();
        name = m;
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param userName
     * @param email
     * @param password
     * @throws RemoteException
     */
    @Override
    public void registration(String firstName, String lastName, String userName, String email, String password) throws RemoteException {

    }

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    @Override
    public void loginAdmin(String userName, String password) throws RemoteException {

    }

    /**
     *
     * @param userName
     * @param password
     * @throws RemoteException
     */
    @Override
    public void loginUser(String userName, String password) throws RemoteException {

    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] browsingAdmin() throws RemoteException {
        return new String[0];
    }

    /**
     *
     * @return
     * @throws RemoteException
     */
    @Override
    public String[] browsingUser() throws RemoteException {
        return new String[0];
    }

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @Override
    public void update(int itemId) throws RemoteException {

    }

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @Override
    public void remove(int itemId) throws RemoteException {

    }

    /**
     *
     * @param itemId
     * @throws RemoteException
     */
    @Override
    public void purchase(int itemId) throws RemoteException {

    }
}


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MPlaceInterface extends Remote{

    void registration(String firstName, String lastName,String userName, String email, String password) throws RemoteException;

    void loginAdmin(String userName, String password) throws RemoteException;

    void loginUser(String userName, String password) throws RemoteException;

    String[] browsingAdmin() throws RemoteException;

    String[] browsingUser() throws RemoteException;

    void update(int itemId) throws RemoteException;

    void remove(int itemId) throws RemoteException;

    void purchase(int itemId) throws RemoteException;


}

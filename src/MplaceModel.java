
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MplaceModel {

    // Ryan: Please include useful comments in each file.
    //fixed
    //private fields so, other classes cannot access these fields
    private String username;
    private String userpass;
    private String adminId;
    private String adminPass;


    DbConnection dbConnection;

    ResultSet resultSet = null;


    public MplaceModel() throws RemoteException {

        //initializing the variables
        username = "amorampu";
        userpass = "1234";
        adminId = "admin";
        adminPass = "12345";

        //creating the object of the DbConnection class.
        dbConnection = new DbConnection();
        //setting the connection
        dbConnection.setConnectionEstablished();
        //name = m;


    }

    boolean loginUser(String uname, String pass) {

        //making a comparison to check if the entered username equals the initialized one
        if (this.username.equals(uname) && this.userpass.equals(pass))

            return true;

        else {
            return false;
        }
    }

    //Athentication for admin
    boolean loginAdmin(String adminId, String adminPass) {
        //System.out.println(adminId +" "+adminPass);
        if (this.adminId.equals(adminId) && this.adminPass.equals(adminPass)) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * purchase method to purchase the items and change the stock to stock - 1 in the database.
     *
     * @param session
     * @param itemId
     * @return
     */
    public boolean purchase(Session session, int itemId) {

        ResultSet resultSet = null;
        int stock = 0;

        //checking if the conection is established
        if (dbConnection.isConnectionEstablished()) {
            try {
                //getting the resultset of the required item to find the available stock
                resultSet = dbConnection.getUniqueItem(itemId);
                while (resultSet.next()) {
                    //getting  the stock and storing it in the stock variable
                    stock = Integer.parseInt(resultSet.getString("item_stock").toString());

                    System.out.println(stock);
                }
                //chaging the result set to previous point as, it is null now
                resultSet.beforeFirst();


                while (resultSet.next()) {
                    if (!(stock <= 0)) {
                        //reduce the stock by 1 after purchase

                        System.out.println("before substraction" + stock);
                        //changing the stock value to stock - 1, so we can update the table
                        stock = stock - 1;

                        System.out.println(stock);
                        //calling the database
                        if (dbConnection.purchaseItems(itemId, stock)) ;
                        {
                            //System.out.println(val);
                            //if success returns true
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                System.out.println("Hello bug");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;


    }

    /**
     *
     * @param session
     * @return
     */
    public List<String> browsingUser(Session session) {

        //Creating a new arrayList to add the items and return it to the Client
        List<String> itemList = new ArrayList<>();
        String data;
        int i = 0;

        //careating a new object of the DbConnection class

        //checking if the connection is established
        if (dbConnection.isConnectionEstablished()) {

            try {

                resultSet = dbConnection.getResultSet();
                while (resultSet.next()) {
                    //getting the result from the database using the DbConnection class
                    data = resultSet.getString("item_id") + "," + resultSet.getString("item_name") + "," + resultSet.getString("item_stock") + "," + resultSet.getString("item_price") + "," + resultSet.getString("item_description");
                    //adding the items into the arrayList
                    itemList.add(i, data);
                    i++;
                }

                return itemList;

                //catching the sql exception
            } catch (SQLException e) {

                System.out.println("cannot get the result!");

            }

        }

        return null;
    }

    /**
     *Add items method to add the items to the database, this is only accessible to admin
     * @param items
     * @return
     */
    public boolean addItems(String[] items) {


        //boolean variable to determine the status of the add item query.
        boolean status;

        if (items != null) {

            //calling the addItems method to add the item into the database.
            status = dbConnection.addItems(items);

            if (status) {
                return true;
            }

            return false;

        }

        return false;

    }

}
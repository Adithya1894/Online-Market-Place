
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
    //Removed the unneccessary fields.


	// Ryan: Shouldn't these have a scope associated with them?
    //Fixed: assigned the scope to the variable.
    private DbConnection dbConnection;

    ResultSet resultSet = null;


    public MplaceModel(){

        //creating the object of the DbConnection class.
        dbConnection = new DbConnection();
        //setting the connection
        dbConnection.setConnectionEstablished();
        //name = m;


    }

    public boolean loginUser(String uname, String pass) {

        //making a comparison to check if the entered username equals the initialized one
        ResultSet resultSet = null;

        //getting the result from the database, only if the values match
        resultSet = dbConnection.loginUser(uname, pass);

        if(resultSet!=null)
            return true;

        return false;
    }

    //Athentication for admin
    boolean loginAdmin(String adminId, String adminPass) {
        //System.out.println(adminId +" "+adminPass);
        ResultSet resultSet = null;

        //getting the result set from the database, if the values match.
        resultSet = dbConnection.loginAdmin(adminId,adminPass);
        //if resultSet is not null, then the user is authenticated, return true
        if(resultSet!=null)
            return true;
        //else return false
        return false;
    }
    //This method is used for new User registration.
    boolean registered(String firstName, String lastName, String userName, String password){

        if(dbConnection.registration(firstName, lastName, userName, password)) {
            return true;
        }
        return false;
    }

    /**
     * purchase method to purchase the items and change the stock to stock - 1 in the database.
     *
     *
     * @param itemId
     * @return
     */
    public boolean purchase(int itemId) {

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
     * @param
     * @return
     */
    public List<String> browsingUser() {

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

        //if items are successfully added into database then return true, else false
        if (dbConnection.addItems(items)) {

            return true;
        }
        return false;
    }

    /**
     * Takes the itemId as input and then deletes the item from the database
     * Returns true if successfully removed the product, else false.
     * @param itemId
     * @return
     * @throws RemoteException
     */
    public boolean removeProduct(int itemId) throws RemoteException {

        if(itemId!=0){
            if(dbConnection.removeProduct(itemId));
                return true;
        }else{
            System.out.println("Item Id cannot be 0");
        }
        return false;
    }

    /**
     * this method is used to add items into the cart of the particular user using the application
     * @param userName
     * @param itemId
     * @return
     */
    public boolean addItemToCart(String userName, int itemId){
        boolean val;

        val = dbConnection.addItemToCart(userName, itemId);




        return val;
    }

    /**
     *
     * @param userName
     * @param itemId
     * @return
     */
    public boolean deleteItemFromCart(String userName, int itemId){
        boolean val;


        val = dbConnection.deleteItemFromCart(userName, itemId);


        return val;
    }

    /**
     *
     * @param userName
     * @return
     */
    public List<String> displayUserCart(String userName){
        List<String> cartList = new ArrayList<String>();

        cartList = dbConnection.displayUserCart(userName);

        return cartList;

    }


}
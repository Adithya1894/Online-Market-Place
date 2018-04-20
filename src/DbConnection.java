// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

// Ryan: Do you really need the entire package here?
//Fixed: only added the required packages
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class DbConnection {


    //boolean variable, set only if the connection is establised to the database server
    private boolean connectionEstablished = false;


    //returns the connection object.
    public Connection getConnection() {
    //checking if the connection is established, if the connection is established then it returns the connection
        if (connectionEstablished)
            return connection;

        return null;
    }

    //static,since we need only one instance of connection
    //used the volatile keyword to make the system more robust towards concurrent requests towards connection
    private volatile Connection connection = null;
    //declaring the variables of type statement and resultSet and assigning them to null.
    Statement statement = null;
    ResultSet resultSet = null;

    //method to establish the connection and set the boolean value
    public void setConnectionEstablished() {

        //Connection and authentication data
        String url = "jdbc:mysql://localhost:3306/amorampu_db";
        String username = "amorampu";
        String password = "amorampu";

        System.out.println("attempting to connect to the database");
        try {

            //loading the jdbc driver for mysql
            Class.forName("com.mysql.jdbc.Driver");


            //trying to connect to the database using drivermanager
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the Database");
            connectionEstablished = true;
            //return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //This method displays all the prodcuts to the user.
    public ResultSet getResultSet() {

        //checking if the connection object is not null
        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery("SELECT * FROM `item`");


                    //Returning the result of executed query at desired location
                    return resultSet;
                } catch (SQLException e1) {
                    System.out.println("Query cannot be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        } else {
            System.out.println("Connection is not established");
            return null;
        }

    }

    public synchronized ResultSet getUniqueItem(int itemId){
        //checking if the connection object is not null
        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery("SELECT * FROM `item` WHERE item_id="+itemId);


                    //Returning the result of executed query at desired location
                    return resultSet;
                } catch (SQLException e1) {
                    System.out.println("Query cannot be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        } else {
            System.out.println("Cannot retreive item, try again");
            return null;
        }
    }

    //this method is to add items to the database by the admin
    public boolean addItems(String[] val) {


        //query to add items into the database
        String query = "INSERT INTO item(item_price,item_stock,item_name,Item_Description) " + "VALUES(" + Integer.parseInt(val[1]) + "," + Integer.parseInt(val[2]) + ",'" + val[3] + "','" + val[4] + "')";

        //checking if connection is not null
        if (connection != null) {

            statement = null;
            try {

                //creating a statement
                statement = connection.createStatement();

                try {
                    //executing the Insert query
                    statement.executeUpdate(query);
                    return true;

                } catch (SQLException e) {
                    e.printStackTrace();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else
            return false;

        return false;
    }

    /**
     * this method is used to purchase the items
     * takes two inputs as parameters which is itemId and stock
     * takes the stock and updates it in the database.
     * @param itemId
     * @param stock
     * @return
     */
    public boolean purchaseItems(int itemId, int stock) {

        //query to reduce the stock once the purchase is made
        String query = "UPDATE item SET item_stock="+stock+" WHERE item_id="+itemId;

        boolean val = executeQuery(query);

        return val;

    }

    /**
     *  This method is used to delete the
     * @param itemId
     * @return
     */
    public boolean removeProduct(int itemId){


        String query = "DELETE FROM item WHERE item_id="+itemId;

        if(connection!=null)
            //assigning the statement to null
            statement = null;

        try {
            //creating a statement.
            statement = connection.createStatement();
            //executing the query
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println("cannot execute query");
            e.printStackTrace();
        }



        return false;
    }

    /**
     * Method which checks the authenticity of Admin
     * @param userName
     * @param password
     * @return
     */
    public ResultSet loginAdmin(String userName, String password){

        //query to find if the user is a valid user
        String query = "SELECT * from tbl_admin where username= \""+userName+ "\" AND password= \""+password + "\"";

        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery(query);


                    //Returning the result of executed query at desired location
                    return resultSet;
                } catch (SQLException e1) {
                    System.out.println("Query cannot be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //returning the resultSet to the Model.
            return resultSet;
        } else {
            System.out.println("Cannot retreive User, try again");
            return null;
        }

    }


    public ResultSet loginUser(String userName, String password){

        //query to find if the user is a valid user
        String query = "SELECT * from tbl_customers where username= \""+userName+ "\" AND password= \""+password + "\"";

        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery(query);


                    //Returning the result of executed query at desired location

                } catch (SQLException e1) {
                    System.out.println("Query can't be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //returning the resultSet to the Model.
            return resultSet;
        } else {
            System.out.println("Cannot retreive Customer, try again");
            return null;
        }

    }

    public boolean registration(String firstName, String lastName, String userName, String password){

        String query = "INSERT INTO tbl_customers(firstName,lastName,userName,password) " + "VALUES('" + firstName + "','" + lastName + "','" + userName + "','" + password + "')";


       boolean val = executeQuery(query);

       return val;

    }

    /**
     * This method is used to add the item into the cart, this is connected to the database
     * @param userName
     * @param itemId
     * @return
     */
    public boolean addItemToCart(String userName, int itemId, int quantity){

        String query = "INSERT INTO tbl_cart(username, item_id, item_quantity) " + "VALUES('" + userName + "','" + itemId + "','" +quantity+"')";

        boolean val = executeQuery(query);

        return val;

    }

    /**
     * THis method is used to delete item from the cart, this is connected to the database
     * @param userName
     * @param itemId
     * @return
     */
    public boolean deleteItemFromCart(String userName, int itemId){

        String query = "DELETE FROM tbl_cart WHERE username= '"+userName+"' AND item_id="+itemId;

        boolean val=executeQuery(query);

        return val;
    }

    /**
     * This method is used to display user cart data.
     * @param userName
     * @return
     */
    public ResultSet displayUserCart(String userName){
        //initializing a new arraylist
        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery("SELECT * FROM tbl_cart WHERE username='"+userName+"'");


                    //Returning the result of executed query at desired location
                    return resultSet;
                } catch (SQLException e1) {
                    System.out.println("Query cannot be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        } else {
            System.out.println("Connection is not established");
            return null;
        }
    }

    /**
     *
     * @param customerDetails
     * @return
     */
    public boolean addNewCustomer(String[] customerDetails){

        //query to add customers into the database
        String query = "INSERT INTO tbl_customers(firstName,lastName,userName,password) " + "VALUES('" + customerDetails[1] + "','" + customerDetails[2] + "','" + customerDetails[3] + "','" + customerDetails[4] + "')";
        //calling the execute query method
        boolean val = executeQuery(query);

        return val;
    }


    /**
     *
     * @param query
     * @return
     */
    public boolean executeQuery(String query){

        //checking if connection is not null
        if (connection != null) {

            statement = null;
            try {

                //creating a statement
                statement = connection.createStatement();

                //executing the Insert query
                try {
                    int val = statement.executeUpdate(query);
                    if(val==1){
                        return true;
                    }else
                        return false;
                }
                catch (SQLException e1){
                    System.out.println("cannot execute query");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }

        return false;
    }

    /**
     *
     * @param adminDetails
     * @return
     */
    public boolean addNewAdmin(String[] adminDetails){

        String query = "INSERT INTO tbl_admin(firstName,lastName,userName,password) " + "VALUES('" + adminDetails[1] + "','" + adminDetails[2] + "','" + adminDetails[3] + "','" + adminDetails[4] + "')";

        boolean val;
        synchronized (this) {

            val = executeQuery(query);
        }
        return val;
    }

    /**
     *
     * @param userId
     * @return
     */
    public boolean removeCustomer(int userId){
        String query = "DELETE FROM tbl_customers where customer_id = " +userId;
        boolean val;
        synchronized (this) {
            val = executeQuery(query);
        }
        return val;
    }

    /**
     *
     * @return
     */
    public ResultSet listAllCustomers(){

        //checking if the connection object is not null
        if (connection != null) {
            statement = null;
            resultSet = null;
            try {

                //creating a statement.
                statement = connection.createStatement();

                try {
                    //Executing the created statement
                    resultSet = statement.executeQuery("SELECT * FROM `tbl_customers`");


                    //Returning the result of executed query at desired location
                    return resultSet;
                } catch (SQLException e1) {
                    System.out.println("Query cannot be executed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return resultSet;
        } else {
            System.out.println("Connection is not established");
            return null;
        }
    }

    /**
     * if the connection is established, then it returns a true.
     * @return
     */
    public boolean isConnectionEstablished () {
        return connectionEstablished;
    }

    public boolean updateItems(int itemId, int choice, String update) {


        switch (choice){


            case 1: {
                try {
                    int stock = Integer.parseInt(update);
                    String query="UPDATE item SET item_stock = '"+stock+"' WHERE item_id ="+itemId;
                    synchronized (this) {
                        return executeQuery(query);
                    }
                }
                catch (NumberFormatException e)
                {
                    e.getMessage();
                }


            }

            case 2: {
                try {
                    int price =  Integer.parseInt(update);
                    String query="UPDATE item SET item_price = '"+price+"' WHERE item_id ="+itemId;
                    synchronized (this) {
                        return executeQuery(query);
                    }
                }catch (NumberFormatException e)
                {
                    e.getMessage();
                }

            }

            case 3: {
                String query = "UPDATE item SET item_description = '" + update + "' WHERE item_id =" + itemId;
                synchronized (this) {
                    return executeQuery(query);
                }
            }

        }
        return false;
    }
}

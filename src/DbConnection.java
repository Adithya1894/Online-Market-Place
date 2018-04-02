// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.sql.*;

public class DbConnection {


    //boolean variable, set only if the connection is establised to the database server
    private boolean connectionEstablished = false;


    //returns the connection object.
    public Connection getConnection() {
        if (connectionEstablished)
            return connection;

        return null;
    }

    //static,since we need only one instance of connection
    private Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    //method to establish the connection and set the boolean value
    public void setConnectionEstablished() {
        //setting the mysql connection variables.
        String hostName = "localhost:3306";
        String dbname = "amorampu_db";

        //Connection and authentication data
        String url = "jdbc:mysql://" + hostName + "/" + dbname;
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

    public ResultSet getUniqueItem(int itemId){
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

    public boolean purchaseItems(int itemId, int stock) {

        //query to reduce the stock once the purchase is made
        String query = "UPDATE item SET item_stock="+stock+" WHERE item_id="+itemId;

        if(connection!=null)
            statement = null;

        try {
            statement = connection.createStatement();
                statement.executeUpdate(query);
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

        public boolean isConnectionEstablished () {
            return connectionEstablished;
        }

}

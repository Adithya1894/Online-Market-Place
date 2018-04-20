// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

/**
 * Admin Interface to be used by AdminFactory to create the object of concrete Admin
 */
public interface Admin {

    /**
     * welcome method
     * @return
     */
    int display(Session session);

    /**
     * browseItems method to access the items
     */
    void browseItems(Session session);

    /**
     * updateItems to update the items
     */
    void updateItems(Session session);

    /**
     * RemoveItems to remove the items
     */
    void removeItems(Session session);


    /**
     * add items method
     * @param session
     */
    void addItems(Session session);

    /**
     *added this new purchase method, which is only accessible to customer, just added this
     * in Admin view to demonstrate the role based access control.
     * @param session
     */
    void purchase(Session session);

    /**
     * This method is used to add new customers into the database
     * @param session
     */
    void addNewCustomer(Session session);

    /**
     * This method is used to add new admin into the database
     * @param session
     */
    void addNewAdmin(Session session);

    /**
     * This method is used to remove already existing customer from the database.
     * @param session
     */
    void removeCusomter(Session session);

    /**
     * This method is used to list all the customers registered in the system.
     * @param session
     */
    void listAllCustomers(Session session);

}

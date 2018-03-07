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
    int display();

    /**
     * browseItems method to access the items
     */
    void browseItems(Session session);

    /**
     * updateItems to update the items
     */
    void updateItems();

    /**
     * RemoveItems to remove the items
     */
    void removeItems();


    /**
     * add items method
     */
    void addItems();

    /**
     *added this new purchase method, which is only accessible to customer, just added this
     * in Admin view to demonstrate the role based access control.
     * @param session
     */
    void purchase(Session session);

}

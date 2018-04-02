
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public interface User {

    /**
     *just the display method which is used by concreteUser class
     */
    int display();

    /**
     *browseItems method which is being used by ConcreteUser class
     * @param session
     */
    void browseItems(Session session);

    /**
     *purchase method which is used by ConcreteUser class
     * @param session
     */
    void purchase(Session session);


}

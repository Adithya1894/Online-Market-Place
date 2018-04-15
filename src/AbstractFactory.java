
// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public abstract class AbstractFactory {

    /**
     * getAdmin method of abstract factory
     * this is used by the factory producer to get the requred object
     * @param admin
     * @return
     */
    abstract Admin getAdmin(String admin);



    /**
     * getUser method of abstract factory
     * this is used by the factory producer to get the User object
     * @param user
     * @return
     */

    abstract User getUser(String user);

    /**
     * getNewUser method of abstract factory
     * this is used by the factory producer to get the newUser object
     * @param user
     * @return
     */
    abstract NewUser getNewUser(String user);
}

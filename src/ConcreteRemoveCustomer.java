// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

/**
 * This class is used to execute the command removeCustomer from the database.
 */
public class ConcreteRemoveCustomer implements Command {

    //private admin field to get the admin object
    private Admin admin;

    //private session field to get the session object.
    private Session session;

    /**
     * This constructor is used to set the object values of admin and session, upon the invocation of this class
     * @param admin
     * @param session
     */
    public ConcreteRemoveCustomer(Admin admin, Session session) {
        this.admin = admin;
        this.session = session;
    }

    /**
     * inherited method from the command interfac, if this method is executed then the command is
     */
    @Override
    public void execute() {

        admin.removeCusomter(session);
    }
}

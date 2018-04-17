// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


public class ConcreteAddNewCustomer implements Command{

    //private Admin object, this is the Interface
    private Admin admin;

    //private session object.
    private Session session;

    /**
     * constructor to initialize the values of admin object and session object
     * @param admin
     * @param session
     */
    public ConcreteAddNewCustomer(Admin admin, Session session) {
        this.admin = admin;
        this.session = session;
    }

    /**
     * when the command is executed, the addNewCustomer method is called.
     */
    @Override
    public void execute() {
        //addNewCustomer command is executed.
        admin.addNewCustomer(session);
    }
}

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class ConcreteListAllCustomers  implements Command{

    //private fields to get the objects of admin and session.
    private Admin admin;

    private Session session;


    /**
     * this method is used to display all the customers present in the database.
     * @param admin
     * @param session
     */
    public ConcreteListAllCustomers(Admin admin, Session session) {
        this.admin = admin;
        this.session = session;
    }

    /**
     * inherited method from the command interface
     */
    @Override
    public void execute() {
        //this is executing the command listAllCustomers.
        admin.listAllCustomers(session);
    }
}

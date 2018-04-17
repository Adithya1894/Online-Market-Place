// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

/**
 * This class is to execute the command AddNewAdmin, this can only be done by administrator.
 */
public class ConcreteAddNewAdmin implements Command{

    //Private Admin fields and session fields.
    private Admin admin;

    private Session session;

    /**
     * this constructor is used to set the object values of session and admin, when this class is invoked.
     * @param admin
     * @param session
     */
    public ConcreteAddNewAdmin(Admin admin, Session session) {
        this.admin = admin;
        this.session = session;
    }


    /**
     * This method is used to add new Admin into the database, this command can only be executed by Administrator.
     */
    @Override
    public void execute() {
        admin.addNewAdmin(session);
    }
}

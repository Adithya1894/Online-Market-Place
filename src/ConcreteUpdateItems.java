// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


//command pattern to implement the UpdateItems method

public class ConcreteUpdateItems implements Command{

    //private Admin object
    private Admin obj;

    //Private Session object
    private Session session;

    /**
     * Constructor, takes a session object as argument and Admin obejct
     * @param obj
     * @param session
     */
    public ConcreteUpdateItems(Admin obj, Session session){
        this.obj = obj;this.session = session;
    }

    /**
     * this method is overridden from the Command interface
     * used to execute the command
     */
    @Override
    public void execute() {

        obj.browseItems(session);
        obj.updateItems(session);

    }
}

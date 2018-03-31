// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

//command pattern to implement the BrowseItems method

public class ConcreteBrowseItems implements Command {

    //private Admin object(Admin is the interface)
    private Admin obj;

    //private Session variable
    private Session session;

    /**
     * Constructor, takes a session object as argument and Admin obejct
     * @param obj
     * @param session
     */
    public ConcreteBrowseItems(Admin obj, Session session) {
        this.obj = obj;
        this.session = session;
    }

    /**
     * this method is overridden from the Command interface
     * used to execute the command
     */
    @Override
    public void execute() {

        //Executes the browseItems command.
        obj.browseItems(session);

    }
}

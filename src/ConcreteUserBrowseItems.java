
// Ryan: Missing Honor Pledge & Digital Signature.

// Ryan: Please include useful comments in each file.

//Fixed: Added the honor pledge and digital signature, Added comments.

// Honor Pledge
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu



public class ConcreteUserBrowseItems implements Command {

    //Private user object
    private User obj;

    //Private Session Object
    private Session session;

    /**
     * Constructor which takes user object and Session Object as arguments
     * @param obj
     * @param session
     */
    public ConcreteUserBrowseItems(User obj, Session session) {
        this.obj = obj;
        this.session = session;
    }

    /**
     * Execute method is used to execute the given command
     */
    @Override
    public void execute() {

        obj.browseItems(session);

    }
}

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


public class ConcreteUserPurchaseItems implements Command {

    //private user object
    private User obj;

    //Private Session object
    private Session session;

    /**
     * Constructor which takes two arguments
     * @param obj
     * @param session
     */
    public ConcreteUserPurchaseItems(User obj, Session session){
        this.obj = obj; this.session = session;
    }

    /**
     * Execute method which used to execute the command
     */
    @Override
    public void execute() {

        obj.purchase(session);
    }

}

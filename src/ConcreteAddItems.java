// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
//command pattern to implement the AddItems method
public class ConcreteAddItems implements Command {
    //private Admin object
    private Admin obj;

    //Private Session object
    private Session session;
    /**
     * constructor, takes a Session and Admin objects as arguments
     * @param obj
     */
    public ConcreteAddItems(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }

    //overridden method for executing the AddItems command
    @Override
    public void execute() {

        obj.addItems();
    }
}

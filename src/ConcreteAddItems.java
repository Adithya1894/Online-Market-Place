// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu
//command pattern to implement the AddItems method
public class ConcreteAddItems implements Command {
    private Admin obj;

    private Session session;
    /**
     * constructor
     * @param obj
     */
    public ConcreteAddItems(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }


    @Override
    public void execute() {

        obj.addItems();
    }
}

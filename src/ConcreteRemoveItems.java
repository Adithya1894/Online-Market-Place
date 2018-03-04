// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


//command pattern to implement the RemoveItems method

public class ConcreteRemoveItems implements Command {

    private Admin obj;

    private Session session;

    public ConcreteRemoveItems(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }

    @Override
    public void execute() {

        obj.removeItems();

    }
}

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


//command pattern to implement the UpdateItems method

public class ConcreteUpdateItems implements Command{

    private Admin obj;

    private Session session;

    public ConcreteUpdateItems(Admin obj, Session session){
        this.obj = obj;this.session = session;
    }

    @Override
    public void execute() {

        obj.updateItems();
    }
}

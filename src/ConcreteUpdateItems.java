// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


//command pattern to implement the UpdateItems method

public class ConcreteUpdateItems implements Command{

    private Admin obj;


    public ConcreteUpdateItems(Admin obj){
        this.obj = obj;
    }

    @Override
    public void execute() {

        obj.updateItems();
    }
}

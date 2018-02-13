// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class ConcreteAddItems implements Command {
    private Admin obj;

    public ConcreteAddItems(Admin obj){
        this.obj = obj;
    }


    @Override
    public void execute() {

        obj.addItems();
    }
}

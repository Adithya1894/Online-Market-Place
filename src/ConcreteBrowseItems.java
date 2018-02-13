// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class ConcreteBrowseItems implements Command {

    private Admin obj;

    public ConcreteBrowseItems(Admin obj){
        this.obj = obj;
    }


    @Override
    public void execute() {

        obj.browseItems();

    }
}


// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class ConcretePurchase implements Command {



    private Admin obj;

    private Session session;

    public ConcretePurchase(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }


    @Override
    public void execute() {

        obj.purchase(session);
    }
}

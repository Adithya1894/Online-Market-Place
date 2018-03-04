
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

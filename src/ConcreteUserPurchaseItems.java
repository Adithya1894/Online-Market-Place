// Ryan: Missing Honor Pledge & Digital Signature.

// Ryan: Please include useful comments in each file.
public class ConcreteUserPurchaseItems implements Command {

    private User obj;

    private Session session;

    public ConcreteUserPurchaseItems(User obj, Session session){
        this.obj = obj; this.session = session;
    }


    @Override
    public void execute() {

        obj.purchase(session);
    }

}

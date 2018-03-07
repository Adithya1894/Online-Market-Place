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

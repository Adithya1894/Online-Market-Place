
public class ConcretePurchase implements Command {



    private Admin obj;

    private Session session;

    public ConcretePurchase(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }


    @Override
    public void execute() {

        Client_Controller client_controller = new Client_Controller();

        //method returns a string of array.
        try {
            client_controller.purchaseItems(session, 3);
            System.out.println("Method not implemented");
        }
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }
    }
}

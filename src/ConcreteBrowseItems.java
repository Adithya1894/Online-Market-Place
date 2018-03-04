// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

//command pattern to implement the BrowseItems method

public class ConcreteBrowseItems implements Command {

    private Admin obj;

    private Session session;

    public ConcreteBrowseItems(Admin obj, Session session){
        this.obj = obj; this.session = session;
    }


    @Override
    public void execute() {

        Client_Controller client_controller = new Client_Controller();

        client_controller.browseAdminItems(session);



        //obj.browseItems();


    }
}

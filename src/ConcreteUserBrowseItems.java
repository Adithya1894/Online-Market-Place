public class ConcreteUserBrowseItems implements Command {


    private User obj;

    private Session session;

    public ConcreteUserBrowseItems(User obj, Session session) {
        this.obj = obj;
        this.session = session;
    }

    @Override
    public void execute() {

        obj.browseItems(session);

    }
}

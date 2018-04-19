// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


public class ConcreteAddToCart implements Command {

    //private user object
    private User user;

    //Private Session object
    private Session session;

    /**
     * Constructor which sets the dependencies of User and Session
     * @param user
     * @param session
     */
    public ConcreteAddToCart(User user, Session session) {
        this.user = user;
        this.session = session;
    }

    /**
     * This method is used to execute the addToCart method
     */
    @Override
    public void execute() {

        user.addToCart(session);

    }
}

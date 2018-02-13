// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class AdminFactory extends AbstractFactory {

    /**
     * AdminFactory to produce the objct of ConcreteAdmin
     * @param admin
     * @return
     */
    @Override
    Admin getAdmin(String admin) {
        //only create the object, if not already created
        if(admin == null)
            return null;
        //if admin equals Admin then object of concrete admin is created
        if(admin.equalsIgnoreCase("Admin")) {
            return new ConcreteAdmin();

        }
        return null;
    }

    @Override
    User getUser(String user) {
        return null;
    }
}

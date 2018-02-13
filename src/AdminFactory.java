public class AdminFactory extends AbstractFactory {


    @Override
    Admin getAdmin(String admin) {

        if(admin == null)
            return null;

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

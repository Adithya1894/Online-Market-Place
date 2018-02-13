public class UserFactory extends AbstractFactory{


    @Override
    Admin getAdmin(String admin) {
        return null;
    }

    @Override
    User getUser(String user) {



        if(user == null)
            return null;

        if(user.equalsIgnoreCase("USER"))

            return new ConcreteUser();

        return null;
    }
}

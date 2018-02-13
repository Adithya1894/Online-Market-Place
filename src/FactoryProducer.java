public class FactoryProducer {

    public static AbstractFactory getFactory(String option){

        if(option.equalsIgnoreCase("Admin")){
            return new AdminFactory();
        }else if(option.equalsIgnoreCase("User"))
            return new UserFactory();

        return null;
    }
}

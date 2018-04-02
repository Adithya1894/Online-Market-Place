// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


/**
 * Factory producer uses the abstract factory to produce the required object of the concrete Classes
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String option){
        //if the user wants a Admin view, then this will return the AdminFactory, if not it will return the UserFactory.
        if(option.equalsIgnoreCase("Admin")){
            return new AdminFactory();
        }else if(option.equalsIgnoreCase("User"))
            return new UserFactory();

        return null;
    }
}

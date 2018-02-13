public abstract class AbstractFactory {

    abstract Admin getAdmin(String admin);

    abstract User getUser(String user);
}

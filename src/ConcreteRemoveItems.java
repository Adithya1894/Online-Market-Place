public class ConcreteRemoveItems implements Command {

    private Admin obj;

    public ConcreteRemoveItems(Admin obj){
        this.obj = obj;
    }

    @Override
    public void execute() {

        obj.removeItems();

    }
}

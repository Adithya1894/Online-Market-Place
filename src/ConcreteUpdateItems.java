public class ConcreteUpdateItems implements Command{

    private Admin obj;


    public ConcreteUpdateItems(Admin obj){
        this.obj = obj;
    }

    @Override
    public void execute() {

        obj.updateItems();
    }
}

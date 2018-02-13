public class ConcreteAddItems implements Command {
    private Admin obj;

    public ConcreteAddItems(Admin obj){
        this.obj = obj;
    }


    @Override
    public void execute() {

        obj.addItems();
    }
}

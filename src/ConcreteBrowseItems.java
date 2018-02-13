public class ConcreteBrowseItems implements Command {

    private Admin obj;

    public ConcreteBrowseItems(Admin obj){
        this.obj = obj;
    }


    @Override
    public void execute() {

        obj.browseItems();

    }
}

import java.util.ArrayList;
import java.util.List;

public class InvokerAdmin {

    private List<Command> olist = new ArrayList<Command>();

    public void takeCommand(Command command){
        olist.add(command);
    }

    public void placeCommand(){

        for(Command command : olist){
            command.execute();
        }

        olist.clear();
    }

}

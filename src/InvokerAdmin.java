// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker class to take the commands and execute them
 */
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

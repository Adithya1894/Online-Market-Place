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

    //takes the list of commands to process and stores them in the arraylist
    public void takeCommand(Command command)
    {
        olist.add(command);
    }
    //takes the List as input and executes each command from the list
    public void placeCommand(){

        for(Command command : olist){
            command.execute();
        }
    //clears the list of commands
        olist.clear();
    }

}

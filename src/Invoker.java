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
public class Invoker {

	// Ryan: What is an olist?
    //Fixed: variable now have a more meaningful name, orderList is the list which takes the orders.
    private List<Command> orderList = new ArrayList<Command>();

    //takes the list of commands to process and stores them in the arraylist
    public void takeCommand(Command command)
    {
        orderList.add(command);
    }
    //takes the List as input and executes each command from the list
    public void placeCommand(){

        for(Command command : orderList){
            command.execute();
        }
    //clears the list of commands
        orderList.clear();
    }

}

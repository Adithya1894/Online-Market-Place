

// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


/**
 * just a sample class to demonstrate remote calls
 */
public class Client_View{


    //creating an object of the client controller to access the client controller
    Client_Controller obj = new Client_Controller();

    /**
     * Prints a hello world to test the application
     */
    public void print(){

        String obj1  = obj.printHello();

            System.out.println(obj1);


    }
}

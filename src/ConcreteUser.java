// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


import java.util.Scanner;

//concrete user class of the Abstractfactory pattern, object of this class is created based upon the logic
public class ConcreteUser implements User {

    /**
     *
     */
    @Override
    public int display() {

        // System.out.println("Welcome User");


        int i = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome Customer");

        System.out.println();


            System.out.println("1.browse Items");
            //System.out.println("2.Update items");
            //System.out.println("3. remove items");
            //System.out.println("4. add Items");
            System.out.println("2.Purchase Items");

            System.out.println("Enter Choice");

            i = sc.nextInt();

            //based on the choice, these values are returned back to the dispatcher of the front controller
            //where it creates the object of this class to access the methods such as browse, update
            switch (i) {


                case 1:
                    return 1;


                case 2:
                    return 2;

                default:System.out.println("Please enter a valid choice! from the menu, you entered" +i);
            }



        return 0;
    }


    /**
     *
     * @param session
     */
    @Override
    public void browseItems(Session session) {

        Client_Controller client_controller = new Client_Controller();

        //method returns a string of array.
        try {
            String[] val = client_controller.browseUserItems(session);
            System.out.println("Nothing in here now, but you are granted access to this method");
        }
        catch (AuthorizationException e){
            e.getMessage();
        }

    }

    /**
     *
     * @param session
     */
    @Override
    public void purchase(Session session) {

        Client_Controller client_controller = new Client_Controller();

        //method returns a string of array.
        try {
            client_controller.purchaseItems(session, 3);
            System.out.println("Method not implemented yet, but you are granted access to this method");
        }
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }
    }


}

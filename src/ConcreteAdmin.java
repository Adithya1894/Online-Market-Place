// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.util.Scanner;

public class ConcreteAdmin implements Admin {

    @Override
    public int display() {
        int i = 0;



        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome Admin");

        System.out.println();



            System.out.println("1.browse Items");
            System.out.println("2.Update items");
            System.out.println("3. remove items");
            System.out.println("4. add Items");
            System.out.println("5.Purchase Items, This Method wont work in ADMIN View(RBAC Demo)");

            System.out.println("Enter Choice");

            i = sc.nextInt();

            //based on the choice, these values are returned back to the dispatcher of the front controller
            //where it creates the object of this class to access the methods such as browse, update
            switch (i) {


                case 1: return 1;


                case 2: return 2;


                case 3: return 3;


                case 4: return 4;

                //added this case for unauthorised method(RBAC)
                case 5: return 5;


            }

            return 0;




    }

    /**
     * concrete methods to browse, update  or delete
     */

    @Override
    public void browseItems(Session session){


        Client_Controller client_controller = new Client_Controller();

        //method returns a string of array.
        try {
            String[] val = client_controller.browseAdminItems(session);
            System.out.println("Nothing in here now");
        }
        catch (AuthorizationException e){
            e.getMessage();
        }


    }


    @Override
    public void updateItems(){


        System.out.println("Update Items will be updated next time");

    }
    @Override
    public void removeItems(){


        System.out.println("Remove Items will be updated next time");

    }
    @Override
    public void addItems(){


        System.out.println("Add Items will be updated next time");

    }

    @Override
    public void purchase(Session session){

        Client_Controller client_controller = new Client_Controller();

        //method returns a string of array.
        try {
            client_controller.purchaseItems(session, 3);
            System.out.println("Method not implemented");
        }
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }


    }


}

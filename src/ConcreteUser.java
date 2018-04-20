// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


import java.util.List;
import java.util.Scanner;

//concrete user class of the Abstractfactory pattern, object of this class is created based upon the logic
public class ConcreteUser implements User {

    Client_Controller client_controller;
    public ConcreteUser() {

         client_controller = new Client_Controller();

    }

    /**
     *
     */
    @Override
    public int display(Session session) {

        // System.out.println("Welcome User");


        int i = 0;

    //getting the input from the user
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome "+session.getUser().getUserName().toUpperCase().toString()+" Enjoy your customized portal");

        System.out.println();



            System.out.println("1.browse Items");
            System.out.println("2.Purchase Items");
            System.out.println("3. List Items in the cart");
            System.out.println("4. Add Items to cart");
            System.out.println("5. Delete From cart");

            System.out.println("Enter Choice");

            i = sc.nextInt();

            //based on the choice, these values are returned back to the dispatcher of the front controller
            //where it creates the object of this class to access the methods such as browse, update
            switch (i) {


                case 1:
                    return 1;


                case 2:
                    return 2;

                case 3:
                    return 3;
                case 4:
                    return 4;

                case 5:
                    return 5;

                default:
                    System.out.println("Please enter a valid choice! from the menu, you entered" + i);
            }


        return 0;
    }

    /**
     *
     * @param session
     */
    @Override
    public void browseItems(Session session) {



        List<String> val;

        //method returns a string of array.
        try {
            //calling the client controller to access the server from the client, and storing the values of the
            //items in the val variable.
            val = client_controller.browseUserItems(session);


            //declaring the string variables. and assigning values to them to display to the user
            String itemId,itemName,itemStock,itemPrice,itemDescription;
            String[] item;
            itemId="Item ID";
            itemName="Item Name";
            itemStock="Stock";
            itemPrice="Price";
            itemDescription = "Description";


            //Formatting the output.
            System.out.printf("\n%-7s %-15s %-10s %-15s %-30s\n",itemId,itemName,itemStock,itemPrice,itemDescription);
            for(int i=0;i<val.size();i++)
            {
                //displaying the formatted output.
                item=val.get(i).split(",");
                for(int j=0;j<item.length;j++)
                {
                    if(j==0){

                        System.out.printf("%-7s",item[j]);
                    }
                    else if(j==1){
                        System.out.printf("%-15s",item[j]);
                    }
                    else if(j==2){
                        System.out.printf("%-10s",item[j]);
                    }
                    else if(j==3){
                        System.out.printf("$"+"%-15s",item[j]);
                    }else{
                        System.out.printf("%-30s", item[j]);
                    }
                }
                System.out.printf("\n");

            }
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

        System.out.println("Enter the itemId: ");
        //creating a scanner object
        Scanner scanner = new Scanner(System.in);
        //taking the item id input from the user.
        int option = scanner.nextInt();
        //method returns a string of array.
        try {
            //purchase items returns a boolean
            if(client_controller.purchaseItems(session, option))
                System.out.println("Item purchase success!");

            else
                System.out.println("Item out of stock");
        }
        //throws an authorization exception if the user is not authorized to access this method.
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addToCart(Session session) {


        System.out.println("Enter the Id of the product to be added to the cart");
        System.out.println("");
        //reading the input from the user
        Scanner sc = new Scanner(System.in);
        //entering the details into the string array

        int itemId =sc.nextInt();

        try {
            //calling the server using client controller and we are passing the session object as well as string array
            boolean status = client_controller.addItemToCart(session, itemId);

            if(status)
                System.out.println("Item added to the cart successfully.");
            else
                System.out.println("problem adding the product, try again");
        }//if the method cannot be accessed, then it throws an authourization exception
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void deleteFromCart(Session session) {

        System.out.println("Enter the Id of the product to be deleted from the cart!");

        Scanner scanner = new Scanner(System.in);

        int itemId = scanner.nextInt();

        try {
            boolean status = client_controller.deleteFromCart(session, itemId);

            if(status)
                System.out.println("Item deleted successfully");

            System.out.println("problem deleting from the cart");
        }catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void listCartItems(Session session) {
        //initialized a empty list of strings
        List<String> val;

        try{
            val = client_controller.listCartItems(session);
            //printing the data from the user cart.
            for(String items: val){
                System.out.println("ItemId: "+items);
            }
        }catch (AuthorizationException e){
            e.getMessage();
        }


    }
}

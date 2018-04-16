// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.util.List;
import java.util.Scanner;

public class ConcreteAdmin implements Admin {

    //variable of client_Controller type, private because, we dont want this instance to be accessed by another file
    private Client_Controller client_controller;

    //creating the instance upon program starting.
    public ConcreteAdmin() {

        client_controller = new Client_Controller();

    }

    /**
     * This method is displayed to user immediately after the login and based on the user input, specific return value is returned
     * @return
     */
    @Override
    public int display(Session session) {
        int i = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome "+session.getUser().getUserName().toUpperCase().toString()+" you have full access to the system");

        System.out.println();

//options displayed to the user
            System.out.println("1.browse Items");
            System.out.println("2.Update items");
            System.out.println("3. remove items");
            System.out.println("4. add Items");
            System.out.println("5.Purchase Items, This Method wont work in ADMIN View(RBAC Demo)");

            System.out.println("Enter Choice");

            //taking the input from the user
            i = sc.nextInt();

            //based on the choice, these values are returned back to the dispatcher of the front controller
            //where it creates the object of this class to access the methods such as browse, update
        while(i!= 6) {
            switch (i) {


                case 1:
                    return 1;


                case 2:
                    return 2;


                case 3:
                    return 3;


                case 4:
                    return 4;

                //added this case for unauthorised method(RBAC)
                case 5:
                    return 5;


                default:
                    System.out.println("Please enter a valid choice! from the menu, you entered" + i);
            }
        }
        return 0;
    }

    /**
     * concrete methods to browse, update  or delete
     */

    @Override
    public void browseItems(Session session){


        List<String> val;

        //method returns a string of array.
        try {

            //calls the server side method using the client controller and then stores the value in the list of Strings.
            val = client_controller.browseUserItems(session);

            //declaring the string variables, and assigning the values to the
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
     * this method is used to update the item values
     * this is not yet implemented
     */
    @Override
    public void updateItems(){



        System.out.println("Update Items will be updated next time");

    }

    /**
     * method to remove the items from the database
     * not yet implemented
     */
    @Override
    public void removeItems(Session session){


        System.out.println("Enter the itemId to be removed");
        //getting the input id from the user.
        Scanner sc = new Scanner(System.in);

        int val = sc.nextInt();
        try {
            //calling the server using client controller and we are passing the session object as well as item id.
            boolean status = client_controller.removeProduct(session, val);

            if(status)
                System.out.println("Item removed successfully from the database");
            else
                System.out.println("problem removing the product, please try again");
        }//if the method cannot be accessed, then it throws an authourization exception
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }


    }

    /**
     * Method to add the items to the database
     * takes Session as an argument to send the session object to the server
     * @param session
     */
    @Override
    public void addItems(Session session){

        //initializing a string array to empty values
        String[] val = {"", "", "", "", ""};
        System.out.println("Enter the details of the items to be added!");
        System.out.println("");
        //reading the input from the user
        Scanner sc = new Scanner(System.in);
        //entering the details into the string array
        for(int i = 1; i < 5; i++){

            if(i == 1){
                System.out.println("Enter the price of the product(Only Integers please)");
                val[i] = sc.nextLine();

            }
            if(i == 2){

                System.out.println("Enter the stock of the product(Only Integers please)");
                val[i] = sc.nextLine();

            }
            if(i == 3){
                System.out.println("enter the name of the product");
                val[i] = sc.nextLine();
            }
            if(i == 4){

                System.out.println("enter the description of the product");
                val[i] = sc.nextLine();
            }

        }
        try {
            //calling the server using client controller and we are passing the session object as well as string array
            boolean status = client_controller.add(session, val);

            if(status)
                System.out.println("Item added into the database successfully.");
            else
            System.out.println("problem adding the product, try again");
        }//if the method cannot be accessed, then it throws an authourization exception
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }


    }

    /**
     * This is just to show the RBAC, This method is not accessible to admin
     * just for demonstrating RBAC, I have kept this method here
     * @param session
     */
    @Override
    public void purchase(Session session){


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

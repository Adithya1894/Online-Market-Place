// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

import java.util.List;
import java.util.Scanner;

public class ConcreteAdmin implements Admin {

    private Client_Controller client_controller;

    public ConcreteAdmin() {

        client_controller = new Client_Controller();

    }

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
            val = client_controller.browseUserItems(session);
            System.out.println("-------------------------------------------");

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


    @Override
    public void updateItems(){


        System.out.println("Update Items will be updated next time");

    }
    @Override
    public void removeItems(){


        System.out.println("Remove Items will be updated next time");

    }
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
                System.out.println("Enter the price of the product");
                val[i] = sc.nextLine();
            }
            if(i == 2){

                System.out.println("Enter the stock of the product");
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
            //
            boolean status = client_controller.add(session, val);

            if(status)
                System.out.println("Item added into the database successfully.");
            else
            System.out.println("problem adding the product, try again");
        }
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }


    }

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

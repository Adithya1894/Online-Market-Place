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
    public int display() {

        // System.out.println("Welcome User");


        int i = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome Customer");

        System.out.println();



            System.out.println("1.browse Items");
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
                        System.out.printf("%-15s"+"$",item[j]);
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


        //method returns a string of array.
        try {
            if(client_controller.purchaseItems(session, 3))
                System.out.println("Item purchase success!");

            else
                System.out.println("Item out of stock");
        }
        catch (AuthorizationException e){
            System.out.println(e.getMessage());
        }
    }
}

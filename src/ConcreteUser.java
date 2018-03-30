// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu


import java.util.ArrayList;
import java.util.List;
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

        List<String> val = new ArrayList<>();

        //method returns a string of array.
        try {
            val = client_controller.browseUserItems(session);
            System.out.println("-------------------------------------------");

            String itemId,itemName,itemStock,itemPrice,itemDescription;
            String[] inditem;
            itemId="Item ID";
            itemName="Item Name";
            itemStock="Stock";
            itemPrice="Price";
            itemDescription = "Description";


            //Formatting the output.
            System.out.printf("\n%s %s %-5s %-10s %-30s\n",itemId,itemPrice,itemStock,itemName,itemDescription);
            for(int i=0;i<val.size();i++)
            {
                inditem=val.get(i).split(",");
                for(int j=0;j<inditem.length;j++)
                {
                    if(j==0){

                        System.out.printf("%s",inditem[j]);
                    }
                    else if(j==1){
                        System.out.printf("%-3s",inditem[j]);
                    }
                    else if(j==2){
                        System.out.printf("%-3s",inditem[j]);
                    }
                    else if(j==3){
                        System.out.printf("%-10s",inditem[j]);
                    }else{
                        System.out.printf("%-30s", inditem[j]);
                    }
                }
                System.out.printf("\n");
                //inditem=null;
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

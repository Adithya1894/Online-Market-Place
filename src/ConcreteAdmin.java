import java.util.Scanner;

public class ConcreteAdmin implements Admin {

    @Override
    public int display() {
        int i = 0;
        int val = 0;
        //ConcreteAdmin obj = new ConcreteAdmin();

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome Admin");

        System.out.println();



            System.out.println("1.browse Items");
            System.out.println("2.Update items");
            System.out.println("3. remove items");
            System.out.println("4. add Items");

            System.out.println("Enter Choice");

            i = sc.nextInt();


            switch (i) {


                case 1: return 1;


                case 2: return 2;


                case 3: return 3;


                case 4: return 4;



            }

            return 0;




    }

    @Override
    public void browseItems(){

        System.out.println("Browse Items will be updated next time");


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


}

public class ConcreteAdmin implements Admin {

    ConcreteAdmin obj = new ConcreteAdmin();
    @Override
    public void display() {
        int i = 0;
        System.out.println("Welcome Admin");

        while(i != 5){

            switch (i){

                case 1: {

                    obj.browseItems();

                    break;
                }


                case 2: updateItems();
                        break;

                case 3: removeItems();
                        break;

                case 4: addItems();
                        break;

                default: System.out.println("enter a valid choice");
            }


        }
    }


    public void browseItems(){


    }

    public void updateItems(){

    }

    public void removeItems(){

    }

    public void addItems(){

    }


}

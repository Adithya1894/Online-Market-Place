// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class Dispatcher {



    private AbstractFactory adminFactory;

    private AbstractFactory userFactory;


    public Dispatcher(){

        adminFactory = FactoryProducer.getFactory("Admin");

        userFactory = FactoryProducer.getFactory("User");

    }

    public void dispatch(String view){


        if(view.equalsIgnoreCase("Admin"))
        {
            Admin admin = adminFactory.getAdmin("Admin");
            int option = admin.display();

            ConcreteBrowseItems cbr = new ConcreteBrowseItems(admin);

            ConcreteUpdateItems cui = new ConcreteUpdateItems(admin);

            ConcreteRemoveItems cri = new ConcreteRemoveItems(admin);

            ConcreteAddItems cai = new ConcreteAddItems(admin);




            InvokerAdmin ia = new InvokerAdmin();


            switch(option){

                case 1: {
                    ia.takeCommand(cbr);
                    ia.placeCommand();
                    break;
                }

                case 2: {
                    ia.takeCommand(cui);
                    ia.placeCommand();
                    break;
                }

                case 3:{
                    ia.takeCommand(cri);
                    ia.placeCommand();
                    break;
                }

                case 4: {
                    ia.takeCommand(cai);
                    ia.placeCommand();
                    break;
                }



        }



        }
        else {

            User user = userFactory.getUser("User");
            user.display();

        }

    }

    public void dispatch_error(String view){
        if(view.equalsIgnoreCase("ERROR")){
            ErrorPage obj = new ErrorPage();
            obj.print();

        }
    }


}

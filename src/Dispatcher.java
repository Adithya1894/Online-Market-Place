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
            admin.display();
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

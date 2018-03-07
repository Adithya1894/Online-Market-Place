// Honor Pledge:
//
// I pledge that I have neither given nor
// received any help on this assignment.
//

//amorampu

public class Dispatcher {


    private AbstractFactory adminFactory;

    private AbstractFactory userFactory;


    public Dispatcher() {
        //trying to access the concrete classes via FactoryProducer
        adminFactory = FactoryProducer.getFactory("Admin");

        userFactory = FactoryProducer.getFactory("User");

    }

    //added the session variable
    public void dispatch(String view, Session session) {

        //gives the object of concrete Admin
        if (view.equalsIgnoreCase("Admin")) {
            //calling the display method of the concreteAdmin class
            Admin admin = adminFactory.getAdmin("Admin");
            int option = admin.display();

            //objects to access the command methods in the concreteAdmin class
            //object of concreteAdmin will be created here
            Command cbr = new ConcreteBrowseItems(admin, session);

            Command cui = new ConcreteUpdateItems(admin, session);

            Command cri = new ConcreteRemoveItems(admin, session);

            Command cai = new ConcreteAddItems(admin, session);

            //this is the unauthorized method, for Admin, demonstrating RBAC
            Command concretePurchase = new ConcretePurchase(admin, session);


            //invoker object to invoke the functionality of command pattern
            Invoker ia = new Invoker();


            switch (option) {

                case 1: {
                    //we are invoking the command and executing them
                    ia.takeCommand(cbr);
                    ia.placeCommand();
                    break;
                }

                case 2: {
                    ia.takeCommand(cui);
                    ia.placeCommand();
                    break;
                }

                case 3: {
                    ia.takeCommand(cri);
                    ia.placeCommand();
                    break;
                }

                case 4: {
                    ia.takeCommand(cai);
                    ia.placeCommand();
                    break;
                }

                //command for RBAC Demo, Admin cannot execute this
                case 5: {
                    ia.takeCommand(concretePurchase);
                    ia.placeCommand();
                }
            }


        }
        //gives the object of customerFactory
        else {

            User user = userFactory.getUser("User");

            int option = user.display();


            Command cbr = new ConcreteUserBrowseItems(user, session);

            Command concreteUserPurchaseItems = new ConcreteUserPurchaseItems(user, session);


            Invoker ia = new Invoker();


            switch (option) {

                case 1: {
                    //we are invoking the command and executing them
                    ia.takeCommand(cbr);
                    ia.placeCommand();
                    break;
                }

                case 2: {
                    ia.takeCommand(concreteUserPurchaseItems);
                    ia.placeCommand();
                    break;
                }


            }

        }
    }
        //if the authentication fails in frontController then the error page is displayed
        public void dispatch_error(String view){
            if(view.equalsIgnoreCase("ERROR")){
                ErrorPage obj = new ErrorPage();
                obj.print();

            }
        }
    }




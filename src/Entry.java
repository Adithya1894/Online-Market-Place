import java.util.Scanner;

public class Entry {

    private int type;

    private String adminUserId;

    private String adminPass;

    private String userId;

    private String pass;


    Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Entry obj = new Entry();
        obj.login();
    }

    public String login() {

          System.out.println(" Enter 1 for Admin Login");
          System.out.println(" Enter 2 for Customer Login");
          System.out.println("Enter your choice: ");

          type = Integer.parseInt(sc.nextLine());

          if(type == 1){

              return "Admin";
          }
          else if(type == 2) {
              return "User";
          }
          return "false";

}

    public  void adminLogin(){


        System.out.println("Enter your userID: ");

        adminUserId = sc.nextLine();

        System.out.println("Enter your password: ");

        adminPass = sc.nextLine();

    }

    public void customerLogin(){

        System.out.println("Enter your userID: ");

        userId = sc.nextLine();

        System.out.println("Enter your password: ");

        pass = sc.nextLine();


    }


    public String getAdminUserId() {
        return adminUserId;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }


}

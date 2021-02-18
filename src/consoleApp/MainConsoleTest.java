package consoleApp;
import java.util.Scanner;

public class MainConsoleTest {

    public static void main(String[] args) {
        MainLogic logic = new MainLogic();
        Scanner sc = new Scanner(System.in);


        System.out.println("*************************************************");
        System.out.println("welcome to my mobilPay app in console view ");
        System.out.println("How can we help you today ? ");
        System.out.println("*************************************************");
        System.out.println("Press 1 for account information");
        System.out.println("Press 2 for a Transaction list on a User ");
        System.out.println("Press 3 to add a new user ");

        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("Indput the userid you are looking for");
                int userIdTemp = sc.nextInt();
                logic.selectSingleUserBasedOnID(userIdTemp);
                break;}

            case 2 -> {
                System.out.println("Indput the UserId to see a transaction list");

            }

            case 3 -> {
                System.out.println("Input users First Name");
                String fName = sc.next();

                System.out.println("Input users Last Name");
                String lName = sc.next();

                System.out.println("Input user E-mail ");
                String eMail = sc.next();

                System.out.println("Input users phone number ");
                int pNumber = sc.nextInt();

                System.out.println("Input country ID");
                int cID = sc.nextInt();

                System.out.println("Input users address");
                String ad = sc.next();

                System.out.println("Input users card ID");
                int cardId =sc.nextInt();

                logic.addNewUser(fName,lName,eMail,pNumber,cID,ad,cardId);
                System.out.println("New user has been added");
            }


        }









    }
}

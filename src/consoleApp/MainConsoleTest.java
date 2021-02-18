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
        System.out.println("");
        System.out.println("Press 1 for account information based on userID");
        System.out.println("Press 2 for a Transaction list on a User ");
        System.out.println("Press 3 to add a new user ");
        System.out.println("Press 4 to delete a User based on ID");
        System.out.println("Press 5 to add a new Card");
        System.out.println("Press 6 to see all user in the system");
        System.out.println("Press 7 to see all Transaction that has happened in the system");



        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("Indput the userID you are looking for");
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

            case 4 -> {
                System.out.println("Input the UserID for the user you wanna delete");
                int deleteThisID = sc.nextInt();
                logic.deleteUser(deleteThisID);
            }

            case 5 -> {

                System.out.println("input the card Number");
                int cdNum = sc.nextInt();
                System.out.println("Input CVV ");
                int cvNum = sc.nextInt();
                System.out.println("Input card owners name ");
                String cardOwnserName = sc.next();
                System.out.println("Input Expiration Date");
                String exDate = sc.next();
                System.out.println("Input cardType 1 = Master Card 2 = Visa");
                int cType = sc.nextInt();
                System.out.println("input the balance");
                double balance = sc.nextDouble();
                logic.addNewCard(cdNum,cvNum,cardOwnserName,cType,exDate,balance);

                System.out.println("New card added");

            }

            case 6 -> {
            logic.showAllUsersInSystem();



            }

            case 7 -> {
                logic.showAllTransActions();
            }

        }









    }
}

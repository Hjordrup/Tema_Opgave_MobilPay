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


        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("Indput the userid you are looking for");
                int userIdTemp = sc.nextInt();
                logic.selectSingleUserBasedOnID(userIdTemp);
                break;
            /*case 2 -> System.out.println("bette");
            case 3 -> logic.selectAll();*/
            }


        }









    }
}

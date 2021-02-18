package consoleApp;

import java.sql.*;
import java.util.Date;

public class MainLogic {

    //Local time to set a regristration date and time for a user.
    private static Date d1 = new Date();

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:datebase/mobilPayDatabase";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void selectSingleUserBasedOnID(int userID){
        String sql = "SELECT UserID, FirstName, LastName, Balance, PhoneNumber, E_mail, Address, Country, Registration_Date, FirstCard, CountryName FROM User join CardInfo CI on CI.CardID = User.FirstCard " +
                "join Bank B on B.CardNumber  = CI.CardNumber join Country C on User.Country = C.CountryID where UserID = '" + userID + "'";



        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                System.out.println("User ID = "+ rs.getInt("UserID")+  ".  First Name is "
                        + rs.getString("FirstName")+ ".  Last Name is "
                        + rs.getString("LastName") + ".  E-mail is "
                        + rs.getString("E_mail") + ".\nPhoneNumber is "
                        + rs.getInt("PhoneNumber") + ".  Address is "
                        + rs.getString("Address") + ". Country of Origin is "
                        + rs.getString("CountryName") + ". Refistration Data is "
                        + rs.getDate("Registration_Date") + ". "
                         + "\n\n"
                );
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    public void addNewUser(String firstName, String lastName, String e_Mail, int phoneNumber, int countryID, String address, int cardID){

        String sql = "INSERT INTO User(firstname, lastname, e_mail, phonenumber, address, country,  Registration_Date, firstcard) VALUES (?,?,?,?,?,?,?,?)";


        try (Connection conn = this.connect();
           PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1,firstName);
            pstm.setString(2,lastName);
            pstm.setString(3,e_Mail);
            pstm.setInt(4,phoneNumber);
            pstm.setString(5,address);
            pstm.setInt(6,countryID);
            pstm.setString(7, String.valueOf(d1));
            pstm.setInt(8,cardID);
            pstm.executeUpdate();
        } catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(int userID){
        String sql ="DELETE FROM User WHERE UserID = ?";


        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,userID);
            pstmt.executeUpdate();
            System.out.println("User has been deleted ");
        }catch(SQLException e ){
            System.out.println(e.getMessage());
            System.out.println("User has not been deleted ");
        }
    }

    public void addNewCard(int cardNumber, int cvv, String Name, int cardType, String exDate){

        String sql = "INSERT INTO CardInfo(cardnumber, ownersFullName , cvv, expirationDate, CardType) VALUES (?,?,?,?,?)";


        try (Connection conn = this.connect();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
                pstm.setInt(1,cardNumber);
                pstm.setString(2,Name);
                pstm.setInt(3,cvv);
                pstm.setString(4,exDate);
                pstm.setInt(5,cardType);
            pstm.executeUpdate();
        } catch(SQLException e ){
            System.out.println(e.getMessage());
        }








    }

}

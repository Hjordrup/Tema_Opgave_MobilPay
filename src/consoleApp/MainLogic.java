package consoleApp;

import java.sql.*;

public class MainLogic {


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
                System.out.println(rs.getInt("UserID")+  ". "
                        + rs.getString("FirstName")+ ". "
                        + rs.getString("LastName") + ". "
                        + rs.getString("E_mail") + ". "
                        + rs.getInt("PhoneNumber") + ".  "
                        + rs.getString("Address") + ". "
                        + rs.getString("CountryName") + ". "
                        + rs.getDate("Registration_Date") + ". "
                         + "\n\n"
                );
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

}

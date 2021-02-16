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


    public void selectAll(){
        String sql = "SELECT * FROM User";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                System.out.println(rs.getInt("User Id")+  ". "
                        + rs.getString("First Name ")+ "\n\n"
                );
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

}

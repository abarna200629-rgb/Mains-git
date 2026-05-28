import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection() {

        try {

            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "kannaki"
            );

            System.out.println("Database Connected");

        } catch (Exception e) {

            System.out.println("Connection Error");
            System.out.println(e);
        }

        return con;
    }
}
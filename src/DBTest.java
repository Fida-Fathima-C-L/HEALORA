import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Healoradb";
        String user = "root";
        String password = "FIDA1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver explicitly
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

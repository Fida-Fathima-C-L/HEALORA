package dao;

import model.User;
import util.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class UserDAO {

    
    public int addUser(User user) {
        String checkSql = "SELECT id FROM users WHERE username=?";
        String insertSql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        int userId = -1;

        try (Connection conn = DatabaseConnection.getConnection()) {

            
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // User already exists
                userId = rs.getInt("id");
                System.out.println(" User already exists, returning existing ID: " + userId);
                return userId;
            }

            
            PreparedStatement insertStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setString(1, user.getUsername());
            insertStmt.setString(2, user.getPassword());
            insertStmt.setString(3, user.getEmail());
            insertStmt.executeUpdate();

            ResultSet generatedKeys = insertStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
            }

            System.out.println(" User added successfully! ID: " + userId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }

    // Get all users
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

package dao;

import model.Feedback;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {

    // Add feedback
    public void addFeedback(Feedback feedback) {
        String sql = "INSERT INTO feedback (user_id, feedback_text) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, feedback.getUserId());
            stmt.setString(2, feedback.getFeedbackText());
            stmt.executeUpdate();
            System.out.println("✅ Feedback added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Get all feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT * FROM feedback";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Feedback(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("feedback_text")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

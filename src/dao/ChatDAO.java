package dao;

import model.Chat;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO {

    // ✅ Add chat message
    public void addChat(Chat chat) {
        String sql = "INSERT INTO chat (user_id, message) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, chat.getUserId());
            stmt.setString(2, chat.getMessage());
            stmt.executeUpdate();
            System.out.println("✅ Chat saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Get all chats
    public List<Chat> getAllChats() {
        List<Chat> list = new ArrayList<>();
        String sql = "SELECT * FROM chat";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Chat(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("message")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✅ Get chats by user
    public List<Chat> getChatsByUser(int userId) {
        List<Chat> list = new ArrayList<>();
        String sql = "SELECT * FROM chat WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Chat(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("message")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

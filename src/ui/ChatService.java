package ui;

import dao.ChatDAO;
import model.Chat;

import java.util.List;

public class ChatService {
    private ChatDAO chatDAO;

    public ChatService() {
        this.chatDAO = new ChatDAO();
    }

    // Add chat message
    public void addChat(int userId, String message) {
        Chat chat = new Chat(userId, message);
        chatDAO.addChat(chat);
    }

    // List all chat messages
    public void listAllChats() {
        List<Chat> chats = chatDAO.getAllChats();
        for (Chat c : chats) {
            System.out.println("💬 User " + c.getUserId() + ": " + c.getMessage());
        }
    }
}

import dao.UserDAO;
import dao.FeedbackDAO;
import dao.ChatDAO;
import dao.PetDAO;   // ✅ import PetDAO
import model.User;
import model.Feedback;
import model.Chat;
import model.Pet;   // ✅ import Pet

import java.util.List;

public class app {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        ChatDAO chatDAO = new ChatDAO();
        PetDAO petDAO = new PetDAO();   // ✅ create petDAO

        // === Show all users ===
        System.out.println("\n--- Users ---");
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.println(u.getId() + " | " + u.getUsername() + " | " + u.getEmail());
        }

        // === Show all feedback ===
        System.out.println("\n--- Feedback ---");
        List<Feedback> feedbacks = feedbackDAO.getAllFeedback();
        for (Feedback f : feedbacks) {
            System.out.println("User " + f.getUserId() + ": " + f.getFeedbackText());
        }

        // === Show all chats ===
        System.out.println("\n--- Chats ---");
        List<Chat> chats = chatDAO.getAllChats();
        for (Chat c : chats) {
            System.out.println("User " + c.getUserId() + ": " + c.getMessage());
        }

        // === Show all pets ===
        System.out.println("\n--- Pets ---");
        List<Pet> pets = petDAO.getAllPets();
        for (Pet p : pets) {
            System.out.println(
                p.getName() + " | Lvl: " + p.getLevel() +
                " | Happiness: " + p.getHappiness() +
                " | Health: " + p.getHealth() +
                " | Energy: " + p.getEnergy()
            );
        }
    }
}



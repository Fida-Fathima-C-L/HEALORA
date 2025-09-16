package ui;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    // Add a new user
    public void registerUser(String username, String password, String email) {
        User user = new User(username, password, email);
        userDAO.addUser(user);
    }

    // Show all users
    public void listAllUsers() {
        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.println("👤 " + u.getUsername() + " | " + u.getEmail());
        }
    }
}


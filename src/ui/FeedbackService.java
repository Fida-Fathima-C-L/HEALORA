package ui;

import dao.FeedbackDAO;
import model.Feedback;

import java.util.List;

public class FeedbackService {
    private FeedbackDAO feedbackDAO;

    public FeedbackService() {
        this.feedbackDAO = new FeedbackDAO();
    }

    // Add feedback
    public void addFeedback(int userId, String text) {
        Feedback feedback = new Feedback(userId, text);
        feedbackDAO.addFeedback(feedback);
    }

    // List all feedback
    public void listAllFeedback() {
       List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        for (Feedback f : feedbackList) {
            System.out.println("💬 User " + f.getUserId() + ": " + f.getFeedbackText());
        }
    }
}


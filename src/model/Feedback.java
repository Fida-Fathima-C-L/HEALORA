package model;

public class Feedback {
    private int id;
    private int userId;
    private String feedbackText;

    public Feedback(int id, int userId, String feedbackText) {
        this.id = id;
        this.userId = userId;
        this.feedbackText = feedbackText;
    }

    public Feedback(int userId, String feedbackText) {
        this(0, userId, feedbackText);
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getFeedbackText() { return feedbackText; }
}


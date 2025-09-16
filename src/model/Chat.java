package model;

public class Chat {
    private int id;
    private int userId;
    private String message;

    public Chat(int id, int userId, String message) {
        this.id = id;
        this.userId = userId;
        this.message = message;
    }

    public Chat(int userId, String message) {
        this(0, userId, message);
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getMessage() { return message; }
}


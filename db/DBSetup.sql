-- ✅ Create the main database
DROP DATABASE IF EXISTS healora;
CREATE DATABASE healora;
USE healora;

-- ✅ Users Table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- ✅ Feedback Table
CREATE TABLE IF NOT EXISTS feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    feedback_text TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ✅ Chat Table
CREATE TABLE IF NOT EXISTS chat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ✅ Pets Table (Member 2 integration)
CREATE TABLE IF NOT EXISTS pets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    level INT DEFAULT 1,
    happiness INT DEFAULT 50,
    health INT DEFAULT 50,
    energy INT DEFAULT 50
);
-- =========================================================
-- CRUD Templates (No data, only structure)
-- =========================================================

-- INSERT (Create)
-- INSERT INTO users (username, password, email) VALUES ('username_here', 'password_here', 'email_here');
-- INSERT INTO feedback (user_id, feedback_text) VALUES (1, 'feedback_here');
-- INSERT INTO chat (user_id, message) VALUES (1, 'message_here');
-- INSERT INTO pets (name, level, happiness, health, energy) VALUES ('PetName', 1, 50, 50, 50);

-- SELECT (Read)
-- SELECT * FROM users;
-- SELECT * FROM feedback;
-- SELECT * FROM chat;
-- SELECT * FROM pets;

-- UPDATE
-- UPDATE users SET email = 'new_email@example.com' WHERE id = 1;
-- UPDATE pets SET happiness = 95 WHERE name = 'Buddy';

-- DELETE
-- DELETE FROM users WHERE id = 1;
-- DELETE FROM pets WHERE id = 1;
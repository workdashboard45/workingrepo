package prog.hello;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class StudentLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String DB_PASSWORD = "1234";
    public StudentLogin() {
        setTitle("Student Registration and Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        add(panel);
        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> register());
        setVisible(true);
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, DB_PASSWORD);
    }

    private void register() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter username and password.");
            return;
        }
        String sql =
                "INSERT INTO students(name, email, username, password_hash)"
                + " VALUES (?, ?, ?, ?)";
        // Demo only: replace with a secure password-hashing implementation.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);       // Demo name
            ps.setString(2, username + "@example.com");
            ps.setString(3, username);
            ps.setString(4, password);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,
                    "Registration successful!");
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(this,
                    "Username or email already exists.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Registration failed: " + ex.getMessage());
        }
    }
    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        String sql =
                "SELECT password_hash FROM students WHERE username = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()
                        && rs.getString("password_hash").equals(password)) {
                    JOptionPane.showMessageDialog(this,
                            "Login successful! Welcome, " + username);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Invalid username or password.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Login failed: " + ex.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentLogin::new);
    }
}


DATABASE Query
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

// StudentManager.java
import java.sql.*;
import java.util.*;

public class StudentManager {
    private final String URL = "jdbc:mysql://localhost:3306/student_db";
    private final String USER = "root";
    private final String PASSWORD = "GJMH007@";

    public StudentManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void addStudent(Scanner scanner) {
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter DOB (DD/MM/YYYY): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        String sql = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prn);
            stmt.setString(2, name);
            stmt.setString(3, dob);
            stmt.setDouble(4, marks);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
    public void displayStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.isBeforeFirst()) {
                System.out.println("No students available.");
                return;
            }
            while (rs.next()) {
                System.out.println("PRN: " + rs.getString("prn") + ", Name: " + rs.getString("name") +
                        ", DOB: " + rs.getString("dob") + ", Marks: " + rs.getDouble("marks"));
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }
    public void searchByPRN(Scanner scanner) {
        System.out.print("Enter PRN to search: ");
        String prn = scanner.nextLine();
        String sql = "SELECT * FROM students WHERE prn = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Student Found: PRN: " + rs.getString("prn") + ", Name: " +
                        rs.getString("name") + ", DOB: " + rs.getString("dob") + ", Marks: " + rs.getDouble("marks"));
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }







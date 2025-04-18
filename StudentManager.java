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



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {

    // Method to insert a new patient
    public static void addPatient(String name, String dob, int age, String disease, String drug) {
        String sql = "INSERT INTO patients (name, date_of_birth, age, disease, drug_issued) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, dob);
            stmt.setInt(3, age);
            stmt.setString(4, disease);
            stmt.setString(5, drug);
            stmt.executeUpdate();
            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to search patient by Date of Birth
    public static void searchPatientByDOB(String dob) {
        String sql = "SELECT * FROM patients WHERE date_of_birth = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dob);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Disease: " + rs.getString("disease"));
                System.out.println("Drugs Issued: " + rs.getString("drug_issued"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


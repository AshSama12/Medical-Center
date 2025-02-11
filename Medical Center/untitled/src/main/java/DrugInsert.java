import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DrugInsert {
    public static void addDrug(String drugName, int count) {
        String sql = "INSERT INTO drugs (drug_name, drug_count) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, drugName);
            stmt.setInt(2, count);
            stmt.executeUpdate();
            System.out.println("Drug added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

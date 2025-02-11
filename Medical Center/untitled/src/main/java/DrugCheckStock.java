import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugCheckStock {
    public static void checkStock() {
        String sql = "SELECT drug_name, drug_count FROM drugs";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String drugName = rs.getString("drug_name");
                int stock = rs.getInt("drug_count");
                System.out.println("Drug: " + drugName + " | Stock: " + stock);

                if (stock <= 100) {
                    System.out.println("⚠ Warning: Low stock for " + drugName + " (" + stock + " left)");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

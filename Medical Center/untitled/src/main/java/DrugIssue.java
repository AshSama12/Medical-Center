import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugIssue {
    public static void issueDrug(String drugName, int quantity) {
        String checkStockSQL = "SELECT drug_count FROM drugs WHERE drug_name = ?";
        String updateStockSQL = "UPDATE drugs SET drug_count = drug_count - ? WHERE drug_name = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement checkStmt = conn.prepareStatement(checkStockSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateStockSQL)) {

            checkStmt.setString(1, drugName);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                int currentStock = rs.getInt("drug_count");

                if (currentStock >= quantity) {
                    updateStmt.setInt(1, quantity);
                    updateStmt.setString(2, drugName);
                    updateStmt.executeUpdate();
                    System.out.println(quantity + " units of " + drugName + " issued successfully.");

                    if (currentStock - quantity <= 100) {
                        System.out.println("⚠ Warning: Stock for " + drugName + " is low! (" + (currentStock - quantity) + " left)");
                    }
                } else {
                    System.out.println("❌ Not enough stock! Available: " + currentStock);
                }
            } else {
                System.out.println("❌ Drug not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

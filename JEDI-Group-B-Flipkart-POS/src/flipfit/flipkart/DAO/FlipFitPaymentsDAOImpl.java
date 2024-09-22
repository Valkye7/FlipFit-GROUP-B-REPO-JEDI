package flipfit.flipkart.DAO;

import flipfit.flipkart.bean.FlipFitPayments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlipFitPaymentsDAOImpl {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "password@123");
    }

    //set payment

    public void setPaymentInfo(FlipFitPayments FFP) {
        String sql = "REPLACE INTO FlipFitPayments (userID, paymentType, paymentInfo) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, FFP.getUserID());
            stmt.setInt(2, FFP.getPaymentType());
            stmt.setString(3, FFP.getPaymentInfo());

            int i = stmt.executeUpdate();
            if (i == 0) {
                throw new SQLException("Creating payment failed. No rows affected.");
            }
        } catch (SQLException e) {
            System.out.println("Error during payment info insertion: " + e.getMessage());
        }
    }

    //delete payment info

    public void deletePaymentInfo(FlipFitPayments FFP) {
        String sql = "DELETE FROM FlipFitPayments WHERE userID = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, FFP.getUserID());

            int i = stmt.executeUpdate();
            System.out.println(i + " payment info deleted");

        } catch (SQLException e) {
            System.out.println("Error during payment info deletion: " + e.getMessage());
        }
    }
}

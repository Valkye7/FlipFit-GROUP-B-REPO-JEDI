package flipfit.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlipFitUpdatePasswordDAOImpl {

    private Connection getConnection() throws SQLException {

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "password@123");
    }


    public boolean validateOldPassword(String email, String oldPassword) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM FlipFitUser WHERE email = ? AND password = ?")) {

            // Check if the entered old password matches the one in the DB
            stmt.setString(1, email);
            stmt.setString(2, oldPassword);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.out.println("Error validating old password : " + e.getMessage());
            return false;
        }
    }


    public boolean updateUserPassword(String email, String oldPassword, String newPassword) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE FlipFitUser SET password = ? WHERE email = ? AND password = ?")) {

            stmt.setString(1, newPassword);
            stmt.setString(2, email);
            stmt.setString(3, oldPassword);

            int rowsUpdated = stmt.executeUpdate();


            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
            return false;
        }
    }
}

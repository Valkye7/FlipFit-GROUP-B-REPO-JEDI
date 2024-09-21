package flipfit.flipkart.DAO;
import flipfit.flipkart.bean.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDAO {


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "password@123");
    }

    //adminLogin

    public boolean adminLogin() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFitGymAdmin WHERE email = ? AND password = ?")) {

            stmt.setString(1, "admin@example.com");
            stmt.setString(2, "password@123");

            try (ResultSet rs = stmt.executeQuery()) {
                boolean res = rs.next();
                if (res) {
                    System.out.println("Logged in Successfully");
                } else {
                    System.out.println("Invalid Credentials !");
                }
                return res;
            }

        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
            return false;
        }
    }

    //get pending owner list

    public List<FlipFitGymOwner> getPendingOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT ownerID, Aadhar FROM FlipFitGymOwner WHERE approved = 0");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserID(rs.getInt("ownerID"));
                owner.setAadhaar(rs.getInt("Aadhar"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pending owners: " + e.getMessage());
        }
        return pendingOwners;
    }


    //get approved owner list

    public List<FlipFitGymOwner> getApprovedOwnerList() {
        List<FlipFitGymOwner> approvedOwners = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM GymOwner WHERE approved = 1");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserID(rs.getInt("ownerID"));
                owner.setAadhaar(rs.getInt("Aadhar"));
                approvedOwners.add(owner);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching approved owners: " + e.getMessage());
        }
        return approvedOwners;
    }


    //get user list

    public List<FlipFitCustomer> getUserList() {
        List<FlipFitCustomer> users = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFitUser");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitCustomer user = new FlipFitCustomer();
                user.setUserID(rs.getInt("userID"));
                user.setFullName(rs.getString("userName"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }

    //validate owner

    public boolean validateOwner() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE FlipFitGymOwner SET approved = 1 WHERE ownerID = ?")) {

            stmt.setInt(1, 1001);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("Failed to validate owner");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error validating owner: " + e.getMessage());
            return false;
        }
        System.out.println("Owner validated successfully");
        return true;
    }

    //delete owner

    public boolean deleteOwner() {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM FlipFitGymOwner WHERE ownerID = ?")) {

            stmt.setInt(1, 1001);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("Failed to delete owner");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting owner: " + e.getMessage());
            return false;
        }
        System.out.println("Owner deleted successfully");
        return true;
    }

    //get list of gym centers

    public List<FlipFitGymCentre> getGymCentreUsingOwnerId() {
        List<FlipFitGymCentre> gymCentres = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FlipFitGymCentre WHERE owner_ID = ? AND approved = 1")) {

            stmt.setInt(1, 1001); // Hardcoded owner ID

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FlipFitGymCentre gymCentre = new FlipFitGymCentre();
                    gymCentre.setCentreID(rs.getInt("centreID"));
                    gymCentre.setCapacity(rs.getInt("capacity"));
                    gymCentre.setCity(rs.getString("city"));
                    gymCentres.add(gymCentre);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching gym centers: " + e.getMessage());
        }
        return gymCentres;
    }
}

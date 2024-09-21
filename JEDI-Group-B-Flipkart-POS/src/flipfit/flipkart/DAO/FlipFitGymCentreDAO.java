package flipfit.flipkart.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import flipfit.flipkart.bean.FlipFitGymCentre;
import flipfit.flipkart.bean.FlipFitSlots;

public class FlipFitGymCentreDAO {
    Random rand = new Random();

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "password@123");
    }

    //create gym center

    public FlipFitGymCentre createGymCentre(FlipFitGymCentre FFGC) {
        String sql = "INSERT INTO FlipFitGymCentre (centreID, ownerID, capacity, approved, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Generate random centreID
            FFGC.setCentreID(rand.nextInt(1000));
            stmt.setInt(1, FFGC.getCentreID());
            stmt.setInt(2, FFGC.getOwnerID());
            stmt.setInt(3, FFGC.getCapacity());
            stmt.setBoolean(4, FFGC.isApproved());
            stmt.setString(5, FFGC.getCity());
            stmt.setString(6, FFGC.getState());
            stmt.setInt(7, FFGC.getPincode());

            int i = stmt.executeUpdate();
            System.out.println(i + " centre added");

        } catch (SQLException e) {
            System.out.println("Error during gym centre creation: " + e.getMessage());
        }
        return FFGC;
    }

    //update gym center

    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre FFGC) {
        String sql = "UPDATE FlipFitGymCentre SET ownerID = ?, capacity = ?, approved = ?, city = ?, state = ?, pincode = ? WHERE centreID = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, FFGC.getOwnerID());
            stmt.setInt(2, FFGC.getCapacity());
            stmt.setBoolean(3, FFGC.isApproved());
            stmt.setString(4, FFGC.getCity());
            stmt.setString(5, FFGC.getState());
            stmt.setInt(6, FFGC.getPincode());
            stmt.setInt(7, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println(i + " centre updated");

        } catch (SQLException e) {
            System.out.println("Error during gym centre update: " + e.getMessage());
        }
        return FFGC;
    }

    //delete gym center

    public void deleteGymCentre(FlipFitGymCentre FFGC) {
        String sql = "DELETE FROM GymCentre WHERE centreID = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, FFGC.getCentreID());

            int i = stmt.executeUpdate();
            System.out.println(i + " centre deleted");

        } catch (SQLException e) {
            System.out.println("Error during gym centre deletion: " + e.getMessage());
        }
    }

    //view gym center

    public ArrayList<FlipFitGymCentre> viewCentres(String city) {
        ArrayList<FlipFitGymCentre> ffarray = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitGymCentre WHERE city = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, city);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitGymCentre FFGC = new FlipFitGymCentre();
                FFGC.setCentreID(rs.getInt("centreID"));
                FFGC.setOwnerID(rs.getInt("ownerID"));
                FFGC.setCapacity(rs.getInt("capacity"));
                FFGC.setApproved(rs.getBoolean("approved"));
                FFGC.setCity(rs.getString("city"));
                FFGC.setState(rs.getString("state"));
                FFGC.setPincode(rs.getInt("pincode"));

                ffarray.add(FFGC);
            }

        } catch (SQLException e) {
            System.out.println("Error during fetching gym centres: " + e.getMessage());
        }
        return ffarray;
    }

    //view available slots

    public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC) {
        ArrayList<FlipFitSlots> ffarray = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitSlots WHERE centreID = ? and seatsAvailable > 0";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, FFGC.getCentreID());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots FFS = new FlipFitSlots();
                FFS.setSlotId(rs.getInt("slotID"));
                FFS.setCentreId(rs.getInt("centreID"));
                FFS.setSeatsAvailable(rs.getInt("seatsAvailable"));
                FFS.setSlotTime(rs.getInt("slotTime"));

                ffarray.add(FFS);
            }

        } catch (SQLException e) {
            System.out.println("Error during fetching available slots: " + e.getMessage());
        }
        return ffarray;
    }
}

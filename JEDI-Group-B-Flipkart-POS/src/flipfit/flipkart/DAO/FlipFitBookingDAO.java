package flipfit.flipkart.DAO;
import flipfit.flipkart.bean.FlipFitBooking;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitBookingDAO {

        // Method to get the database connection
        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "password@123");
        }

        // make booking

        public FlipFitBooking makeBooking(FlipFitBooking booking) {

            String sql = "INSERT INTO FlipFitBooking (userID, slotID, slotTime, isDeleted) VALUES (?, ?, ?, ?)";

            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


                stmt.setInt(1, booking.getUserId());
                stmt.setInt(2, booking.getSlotId());
                stmt.setInt(3, booking.getSlotTime());
                stmt.setBoolean(4, booking.isdeleted());

                // Execute the statement and check if a row was affected
                int affectedRows = stmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating booking failed, no rows affected.");
                }

                // Retrieve the generated bookingID
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {

                        booking.setBookingId(generatedKeys.getInt(1));
                        booking.setIsdeleted(false);
                    } else {
                        throw new SQLException("Creating booking failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {

                System.out.println("Error during booking creation: " + e.getMessage());
            }

            return booking;
        }



    //delete booking

    public boolean deleteBooking(int bookingId) {
        String sql = "DELETE FROM FlipFitBooking WHERE bookingID = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("No booking found to delete with ID: " + bookingId);
                return false;
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Error during booking deletion: " + e.getMessage());
            return false;
        }
    }

    //get booking list

    public List<FlipFitBooking> getAllBookings(int userId) {
        List<FlipFitBooking> bookings = new ArrayList<>();

        String sql = "SELECT * FROM FlipFitBooking WHERE userId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setUserId(rs.getInt("userID"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setIsdeleted(rs.getBoolean("isdeleted"));
                    bookings.add(booking);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving bookings for user ID: " + userId + ", " + e.getMessage());
        }
        return bookings;
    }

    //get booking details

    public List<FlipFitBooking> getBookingDetails(int bookingId) {
        List<FlipFitBooking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM FlipFitBooking WHERE bookingID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setUserId(rs.getInt("userID"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setIsdeleted(rs.getBoolean("isdeleted"));
                    bookings.add(booking);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving booking details for booking ID: " + bookingId + ", " + e.getMessage());
        }
        return bookings;
    }

    //get booking details

    public FlipFitBooking getBookingDetailsByBookingId(int bookingId) {
        FlipFitBooking booking = null;
        String sql = "SELECT * FROM FlipFitBooking WHERE bookingID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    booking = new FlipFitBooking();
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setSlotTime(rs.getInt("slotTime"));
                    booking.setIsdeleted(rs.getBoolean("isdeleted"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving booking details by ID: " + bookingId + ", " + e.getMessage());
        }
        return booking;
    }
}

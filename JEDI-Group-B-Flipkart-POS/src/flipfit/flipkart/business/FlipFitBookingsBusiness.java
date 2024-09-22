package flipfit.flipkart.business;

import flipfit.flipkart.client.FlipFitPaymentMenu;
import flipfit.flipkart.DAO.FlipFitGymCustomerDAOImpl;
import flipfit.flipkart.bean.FlipFitBooking;
import flipfit.flipkart.bean.FlipFitSlots;
import flipfit.flipkart.DAO.FlipFitBookingDAOImpl;
import flipfit.flipkart.DAO.FlipFitSlotDAOImpl;

import java.util.Scanner;

public class FlipFitBookingsBusiness {

    private final FlipFitBookingDAOImpl bookingDAO;


    public FlipFitBookingsBusiness() {
        this.bookingDAO = new FlipFitBookingDAOImpl();
    }

    public FlipFitBooking makeBooking(int userID, int centreID, int startTime) {
        Scanner sc = new Scanner(System.in);

        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        FlipFitSlots slotdetails = slotDAO.getSlotDetails(startTime, centreID);

        FlipFitGymCustomerDAOImpl FFGymCustomer = new FlipFitGymCustomerDAOImpl();
        FlipFitGymCustomerBusiness flipFitCustomerBusiness = new FlipFitGymCustomerBusiness(FFGymCustomer);

        if (slotdetails != null && slotdetails.getSeatsAvailable() > 0) {
            FlipFitBooking booking = flipFitCustomerBusiness.checkBookingConflicts(userID, startTime);
            if (booking != null) {
                System.out.println("The user has already booked a slot at the same time.");
                deleteBooking(booking.getBookingId());
            }

            // Create a new booking
            booking = new FlipFitBooking();
            booking.setSlotId(slotdetails.getSlotId());
            booking.setSlotTime(slotdetails.getSlotTime());
            booking.setUserId(userID);
            booking.setIsdeleted(false);


            if (FlipFitPaymentMenu.getFlipFitPaymentMenu(userID)) {
                System.out.println("Payment successful");
            }

            // Save the booking
            bookingDAO.makeBooking(booking);

            // Update the slot availability
            int seatsAvailable = slotdetails.getSeatsAvailable();
            slotdetails.setSeatsAvailable(seatsAvailable - 1);

            FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
            flipFitSlotsBusiness.updateAvailability(slotdetails);

            System.out.println("Slot booked successfully");
            return booking;
        }
        return null;
    }

    public void deleteBooking(int bookingId) {
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitBooking bookingDetails = bookingDAO.getBookingDetailsByBookingId(bookingId);

        if (bookingDetails == null) {
            return;
        }

        int slotId = bookingDetails.getSlotId();
        FlipFitSlotDAOImpl flipFitSlotDAOImpl = new FlipFitSlotDAOImpl();
        FlipFitSlots flipFitSlots = flipFitSlotDAOImpl.getSlotDetailsById(slotId);

        if (flipFitSlots != null) {
            int seatsAvailable = flipFitSlots.getSeatsAvailable();
            flipFitSlots.setSeatsAvailable(seatsAvailable + 1);

            FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
            flipFitSlotsBusiness.updateAvailability(flipFitSlots);
        }

        bookingDAO.deleteBooking(bookingId);
    }
}

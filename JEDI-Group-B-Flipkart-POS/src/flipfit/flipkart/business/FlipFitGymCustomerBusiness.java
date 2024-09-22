package flipfit.flipkart.business;

import flipfit.flipkart.bean.*;
import flipfit.flipkart.DAO.*;
import java.util.List;


public class FlipFitGymCustomerBusiness {


    public static class InvalidChoiceException extends Throwable {
        public InvalidChoiceException(String message) {
            super(message);
        }
    }

    private final FlipFitGymCustomerDAOImpl flipFitGymCustomerDAOImpl;

    public FlipFitGymCustomerBusiness(FlipFitGymCustomerDAOImpl FFGymCustomer) {
        this.flipFitGymCustomerDAOImpl = FFGymCustomer;
    }

    public List<FlipFitBooking> viewBookedSlots(int userId) {
        System.out.println("Viewing booked slots:> ");
        FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
        FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
        List<FlipFitBooking> bookingsList = bookingDAO.getAllBookings(userId);

        for (FlipFitBooking booking : bookingsList) {
            FlipFitSlots slotdetails = slotDAO.getSlotDetailsById(booking.getSlotId());
            System.out.println("Booking ID: " + booking.getBookingId() + " Slot timing " + slotdetails.getSlotTime());
        }

        return bookingsList;
    }

    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        System.out.println("Checking conflict for slot " + slotTime);
        return flipFitGymCustomerDAOImpl.checkBookingConflicts(userId, slotTime);
    }

    public List<FlipFitGymCentre> viewCentres() {
        System.out.println("view centres called:> ");
        return flipFitGymCustomerDAOImpl.viewCentres();
    }

    public boolean makePayment(int userId) {
        System.out.println("Make payment called:> ");
        flipFitGymCustomerDAOImpl.makePayment(userId);
        return true;
    }

    public FlipFitGymCustomerBusiness editDetails(FlipFitGymCustomerBusiness flipFitGymCustomer) throws InvalidChoiceException {
        return flipFitGymCustomerDAOImpl.editDetails(flipFitGymCustomer);
    }

    public FlipFitGymCustomerBusiness registerCustomer(FlipFitCustomer flipFitGymCustomer) {
        FlipFitRole flipFitUser = new FlipFitRole();
        flipFitUser.setPassword(flipFitGymCustomer.getPassword());
        flipFitUser.setEmailID(flipFitGymCustomer.getEmail());
        flipFitUser.setPhoneNumber(flipFitGymCustomer.getPhoneNumber());
        flipFitUser.setUserName(flipFitGymCustomer.getFullName());
        flipFitUser.setRoleID(0);
        flipFitGymCustomer.setRole(0);
        flipFitGymCustomerDAOImpl.addUser(flipFitUser);
        return flipFitGymCustomerDAOImpl.addCustomer(flipFitGymCustomer, flipFitUser);
    }



    public FlipFitRole login(FlipFitRole flipFitUser) {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(0);
        flipFitUser = userDAO.loginAsCustomer(flipFitUser.getEmailID(), flipFitUser.getPassword());
        return flipFitUser;
    }
}

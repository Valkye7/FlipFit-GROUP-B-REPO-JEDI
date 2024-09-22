package flipfit.flipkart.business;

import flipfit.flipkart.bean.*;
import flipfit.flipkart.DAO.*;

import java.util.List;

public class FlipFitGymOwnerBusiness {

    public static class InvalidChoiceException extends Throwable {
        public InvalidChoiceException(String message) {
            super(message);
        }
    }

    private final FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO;

    public FlipFitGymOwnerBusiness(FlipFitGymOwnerDAOImpl FFOwner) {
        this.flipFitGymOwnerDAO = FFOwner;
    }

    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) {
        return flipFitGymOwnerDAO.addCentre(flipFitGymCentre);
    }

    public FlipFitSlots addSlot(FlipFitSlots flipFitSlot) {
        FlipFitSlotDAOImpl flipFitSlotDAOImpl = new FlipFitSlotDAOImpl();
        flipFitSlotDAOImpl.addSlot(flipFitSlot);
        return flipFitSlot;
    }

    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner) {
        System.out.println("Centres listed:> ");
        return flipFitGymOwnerDAO.viewCentresByOwnerID(flipFitGymOwner);
    }

    public List<FlipFitPayments> viewPayments() {
        System.out.println("Payments listed:> ");
        return null; // Implement if needed
    }

    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) throws InvalidChoiceException {
        return flipFitGymOwnerDAO.editDetails(owner);
    }

    public FlipFitGymOwner registerOwner(FlipFitGymOwner gymOwner) {
        FlipFitRole user = new FlipFitRole();
        user.setPassword(gymOwner.getPassword());
        user.setEmailID(gymOwner.getEmail());
        user.setPhoneNumber(gymOwner.getPhoneNumber());
        user.setUserName(gymOwner.getFullName());
        user.setRoleID(1);
        gymOwner.setRole(1);

        user = flipFitGymOwnerDAO.addUser(user);
        return flipFitGymOwnerDAO.addGymOwner(gymOwner, user);
    }

    public FlipFitRole login(FlipFitRole flipFitUser) {
        FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
        flipFitUser.setRoleID(1);
        flipFitUser = userDAO.loginAsOwner(flipFitUser.getEmailID(), flipFitUser.getPassword());
        return flipFitUser;
    }
}
